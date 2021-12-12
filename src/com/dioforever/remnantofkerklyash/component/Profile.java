package com.dioforever.remnantofkerklyash.component;

public class Profile {

    private Skills skills;

    public Profile(Skills skills){
        this.skills = skills;
    }

    public Skills getSkills(){
        return skills;
    }
    public void setSkills(Skills skills){
        this.skills = skills;
    }
}