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
 * NewPet
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-09-17T16:31:34.688803+02:00[Europe/Berlin]", comments = "Generator version: 7.8.0")
public class NewPet {

  private String name;

  private String tag;

  public NewPet() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public NewPet(String name) {
    this.name = name;
  }

  public NewPet name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
   */
  @NotNull 
  @Schema(name = "name", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public NewPet tag(String tag) {
    this.tag = tag;
    return this;
  }

  /**
   * Get tag
   * @return tag
   */
  
  @Schema(name = "tag", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("tag")
  public String getTag() {
    return tag;
  }

  public void setTag(String tag) {
    this.tag = tag;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NewPet newPet = (NewPet) o;
    return Objects.equals(this.name, newPet.name) &&
        Objects.equals(this.tag, newPet.tag);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, tag);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NewPet {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    tag: ").append(toIndentedString(tag)).append("\n");
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

    private NewPet instance;

    public Builder() {
      this(new NewPet());
    }

    protected Builder(NewPet instance) {
      this.instance = instance;
    }

    protected Builder copyOf(NewPet value) { 
      this.instance.setName(value.name);
      this.instance.setTag(value.tag);
      return this;
    }

    public NewPet.Builder name(String name) {
      this.instance.name(name);
      return this;
    }
    
    public NewPet.Builder tag(String tag) {
      this.instance.tag(tag);
      return this;
    }
    
    /**
    * returns a built NewPet instance.
    *
    * The builder is not reusable (NullPointerException)
    */
    public NewPet build() {
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
  public static NewPet.Builder builder() {
    return new NewPet.Builder();
  }

  /**
  * Create a builder with a shallow copy of this instance.
  */
  public NewPet.Builder toBuilder() {
    NewPet.Builder builder = new NewPet.Builder();
    return builder.copyOf(this);
  }

}

