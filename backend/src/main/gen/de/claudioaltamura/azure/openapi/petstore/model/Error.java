package de.claudioaltamura.azure.openapi.petstore.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * Error
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-09-06T18:19:57.581735+02:00[Europe/Berlin]", comments = "Generator version: 7.8.0")
public class Error {

  private Integer code;

  private String message;

  public Error() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public Error(Integer code, String message) {
    this.code = code;
    this.message = message;
  }

  public Error code(Integer code) {
    this.code = code;
    return this;
  }

  /**
   * Get code
   * @return code
   */
  @NotNull 
  @Schema(name = "code", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("code")
  public Integer getCode() {
    return code;
  }

  public void setCode(Integer code) {
    this.code = code;
  }

  public Error message(String message) {
    this.message = message;
    return this;
  }

  /**
   * Get message
   * @return message
   */
  @NotNull 
  @Schema(name = "message", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("message")
  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Error error = (Error) o;
    return Objects.equals(this.code, error.code) &&
        Objects.equals(this.message, error.message);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, message);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Error {\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
  
  public static class Builder {

    private Error instance;

    public Builder() {
      this(new Error());
    }

    protected Builder(Error instance) {
      this.instance = instance;
    }

    protected Builder copyOf(Error value) { 
      this.instance.setCode(value.code);
      this.instance.setMessage(value.message);
      return this;
    }

    public Error.Builder code(Integer code) {
      this.instance.code(code);
      return this;
    }
    
    public Error.Builder message(String message) {
      this.instance.message(message);
      return this;
    }
    
    /**
    * returns a built Error instance.
    *
    * The builder is not reusable (NullPointerException)
    */
    public Error build() {
      try {
        return this.instance;
      } finally {
        // ensure that this.instance is not reused
        this.instance = null;
      }
    }

    @Override
    public String toString() {
      return getClass() + "=(" + instance + ")";
    }
  }

  /**
  * Create a builder with no initialized field (except for the default values).
  */
  public static Error.Builder builder() {
    return new Error.Builder();
  }

  /**
  * Create a builder with a shallow copy of this instance.
  */
  public Error.Builder toBuilder() {
    Error.Builder builder = new Error.Builder();
    return builder.copyOf(this);
  }

}
