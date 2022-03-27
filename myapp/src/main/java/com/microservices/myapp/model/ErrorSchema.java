package com.microservices.myapp.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ErrorSchema {
    private String errorCode;
    private ErrorMessage errorMessage;

    public static class ErrorMessage {
        private String english;
        private String indonesian;

        public ErrorMessage(String english, String indonesian) {
            this.english = english;
            this.indonesian = indonesian;
        }

        public String getEnglish() {
            return english;
        }

        public void setEnglish(String english) {
            this.english = english;
        }

        public String getIndonesian() {
            return indonesian;
        }

        public void setIndonesian(String indonesian) {
            this.indonesian = indonesian;
        }
    }
}
