package com.udacity.jwdnd.course1.cloudstorage.model;

public class Note {

    private Integer noteid;
    private String notetitle;
    private String notedescription;
    private int userid;

    public Note(String notetitle, String notedescription, int userid) {

        this.notetitle = notetitle;
        this.notedescription = notedescription;
        this.userid = userid;
    }


    public Integer getNoteId() {
        return noteid;
    }

    public String getNoteTitle() {
        return notetitle;
    }

    public String getNoteDescription() {
        return notedescription;
    }

    public int getUserId() {
        return userid;
    }

    public void setNoteid(Integer noteid) {
        this.noteid = noteid;
    }

    public void setNotetitle(String notetitle) {
        this.notetitle = notetitle;
    }

    public void setNotedescription(String notedescription) {
        this.notedescription = notedescription;
    }

    public void setUserId(int userid) {
        this.userid = userid;
    }

}
