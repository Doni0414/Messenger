package com.company;

public class WebFramework {
    public void save(IForm frm){
        MySQL db = new MySQL();
        db.save(frm);
    }
}
