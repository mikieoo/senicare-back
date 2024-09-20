package com.korit.senicare.common.object;

import com.korit.senicare.entity.ToolEntity;

import lombok.Getter;

@Getter
public class Tool {
    
    private Integer toolNumber;
    private String name;
    private String purpose;
    private Integer count;

    private Tool(ToolEntity toolEntity) {
        this.toolNumber = toolEntity.getToolNumber();
        this.name = toolEntity.getName();
        this.purpose = toolEntity.getPurpose();
        this.count = toolEntity.getCount();
    }

}
