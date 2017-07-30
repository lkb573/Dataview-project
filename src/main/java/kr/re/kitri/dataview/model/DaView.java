package kr.re.kitri.dataview.model;

import java.sql.Date;

public class DaView {
    private String addr1;
    private int areacode;
    private int contenttypeid;
    private Date eventstartdate;
    private Date eventenddate;
    private String firstimage;
    private double mapx;
    private double mapy;
    private int readcount;
    private String tel;
    private String title;



    public String getAddr1() {
        return addr1;
    }

    public void setAddr1(String addr1) {
        this.addr1 = addr1;
    }

    public int getAreacode() {
        return areacode;
    }

    public void setAreacode(int areacode) {
        this.areacode = areacode;
    }

    public int getContenttypeid() {
        return contenttypeid;
    }

    public void setContenttypeid(int contenttypeid) {
        this.contenttypeid = contenttypeid;
    }

    public Date getEventstartdate() {
        return eventstartdate;
    }

    public void setEventstartdate(Date eventstartdate) {
        this.eventstartdate = eventstartdate;
    }

    public Date getEventenddate() {
        return eventenddate;
    }

    public void setEventenddate(Date eventenddate) {
        this.eventenddate = eventenddate;
    }

    public String getFirstimage() {
        return firstimage;
    }

    public void setFirstimage(String firstimage) {
        this.firstimage = firstimage;
    }

    public double getMapx() {
        return mapx;
    }

    public void setMapx(double mapx) {
        this.mapx = mapx;
    }

    public double getMapy() {
        return mapy;
    }

    public void setMapy(double mapy) {
        this.mapy = mapy;
    }

    public int getReadcount() {
        return readcount;
    }

    public void setReadcount(int readcount) {
        this.readcount = readcount;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public DaView(String addr1, int areacode, int contenttypeid, Date eventstartdate, Date eventenddate, String firstimage, double mapx, double mapy, int readcount, String tel, String title) {
        this.addr1 = addr1;
        this.areacode = areacode;
        this.contenttypeid = contenttypeid;
        this.eventstartdate = eventstartdate;
        this.eventenddate = eventenddate;
        this.firstimage = firstimage;
        this.mapx = mapx;
        this.mapy = mapy;
        this.readcount = readcount;
        this.tel = tel;
        this.title = title;
    }
}
