package com.wiley.sbconcepts.model;

package com.wiley.sbconcepts.model;

import javax.validation.constraints.NotEmpty;

public class Registration {

    @NotEmpty
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
