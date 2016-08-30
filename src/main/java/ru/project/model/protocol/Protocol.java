package ru.project.model.protocol;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by averizhnikov on 25.08.2016.
 */
public class Protocol {

      @JsonProperty("type")
      private String type; // “TYPE_OF_MESSAGE” , // строка, тип сообщения

      @JsonProperty("sequence_id")
      private String sequenceId; //”: “09caaa73-b2b1-187e-2b24-683550a49b23”, // строка, идентификатор

      public Protocol() {

      }

      public Protocol(String type, String sequenceId) {
            this.type = type;
            this.sequenceId = sequenceId;
      }

      public String getType() {
            return type;
      }

      public void setType(String type) {
            this.type = type;
      }

      public String getSequenceId() {
            return sequenceId;
      }

      public void setSequenceId(String sequenceId) {
            this.sequenceId = sequenceId;
      }
}
