project.controller('loginCtrl', function($scope, $window) {

    var stompClient = null;
    var URL = "/login";
    var SEND_POINT = "/app/login";
    var RECV_POINT = "/topic/login";

    $scope.login = {
                     email:"ddd@aaa.ru",
                     password:"password",
                     response: null,
                     authResult: null,
                     protocol: null
                   };

    var onSubscribe = function (response) {
                                 $scope.login.response = response.body;
                                 console.log(response.body);
                                 $scope.login.protocol = JSON.parse(response.body);
                                 onAuth(JSON.parse(response.body));
                                 $scope.$apply();
    };

    var onAuth = function (protocol) {
        if (protocol) {
            if (protocol.type == "CUSTOMER_ERROR") {
                $scope.login.authResult = false;
            }
            if (protocol.type == "CUSTOMER_API_TOKEN") {
                $scope.login.authResult = true;
            }
        }
    }

    $window.onload = function() {
                        var socket = new SockJS(URL);
                        stompClient = Stomp.over(socket);
                        stompClient.connect({}, function(frame) {
                            stompClient.subscribe(RECV_POINT,onSubscribe);
                        });
    };

    $scope.login.onLoginClickButton = function(email, password) {
        console.log(email + " " + password);
        stompClient.send(SEND_POINT,
                         {},
                         JSON.stringify(
                                        {
                                            'type':"LOGIN_CUSTOMER",
                                            'sequence_id': uuid.v4(),
                                            'data':
                                                    {
                                                      'email': email,
                                                      'password': password
                                                    }
                                        }
                                    )
                                );
    };

});
