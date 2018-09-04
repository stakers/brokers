/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package brokers.model;

import java.io.Serializable;

/**
 *
 * @author tiyakubu
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.wordnik.swagger.annotations.ApiModelProperty;
import java.util.List;

/**
 *
 * @author tiyakubu
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RestResponse implements Serializable{
    private static final long serialVersionUID=20854319573L;
    
    @ApiModelProperty(value="", required=true)
    private String code;
    
    @ApiModelProperty(value="", required=true)
    private String description;
    
    private List<Error> errors;
    @JsonIgnore
    private Object data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Error> getErrors() {
        return errors;
    }

    public void setErrors(List<Error> errors) {
        this.errors = errors;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
    
    public RestResponse(){
    }
    
    public RestResponse(String code, String description){
    this.code=code;
    this.description=description;
    }
    
    
}
