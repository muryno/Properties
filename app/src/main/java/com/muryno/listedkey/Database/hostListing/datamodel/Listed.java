package com.muryno.listedkey.Database.hostListing.datamodel;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.util.ArrayList;

/**
 * Created by muraino harbeola on 9/17/2018.
 */
@Entity
public class Listed {
    @PrimaryKey(autoGenerate = true)
    private int listId;

    private int prog_perc;

    private String prop_titl;
    private String prop_spac;
    private String prop_spac_befr;
    private String desc_spac;
    private String tot_gust;
    private String rom_typ;
    private int room_num;
    private int bed_num;
    private String bed_typ;
    private int min_sty;

    private String contry;
    private String strt;
    private String apt_sut;
    private String city;
    private String stat;
    private String zip_cod;
    private Double latid;
    private Double longt;



    private String phot;
    private ArrayList<String> list_photos = new ArrayList<>();

    public String getPhot() {
        return phot;
    }

    public void setPhot(String phot) {
        this.phot = phot;
    }

    public ArrayList <String> getList_photos() {
        return list_photos;
    }

    public void setList_photos(ArrayList <String> list_photos) {
        this.list_photos = list_photos;
    }

    private int tow_sop;
    private int wir_inter;
    private int shamp;
    private int hangr;
    private int tv;
    private int heat;
    private int ar_cond;
    private int break_cofe;
    private int smk_det;
    private int cabon;
    private int firs_aid;
    private int saft_card;
    private int fir_exting;
    private int kitch;
    private int laudr_washr;
    private int laudr_dryr;
    private int fre_pac;
    private int elev;
    private int pool;
    private int hot_tub;
    private int gym;

    private String adv_not;
    private String resr_spac;
    private String reserv_requst;

    private String arriv_aftr;
    private String arriv_befr;
    private String leav_befr;
    private String gues_offn;

    private ArrayList<String> calendr = new ArrayList<>();

    public ArrayList <String> getCalendr() {
        return calendr;
    }

    public void setCalendr(ArrayList <String> calendr) {
        this.calendr = calendr;
    }

    private String spec_offr;
    private String pric;
    private String curncy;

    public int getListId() {
        return listId;
    }

    public void setListId(int listId) {
        this.listId = listId;
    }

    public int getProg_perc() {
        return prog_perc;
    }

    public void setProg_perc(int prog_perc) {
        this.prog_perc = prog_perc;
    }


    public String getProp_titl() {
        return prop_titl;
    }

    public void setProp_titl(String prop_titl) {
        this.prop_titl = prop_titl;
    }

    public String getProp_spac() {
        return prop_spac;
    }

    public void setProp_spac(String prop_spac) {
        this.prop_spac = prop_spac;
    }

    public String getProp_spac_befr() {
        return prop_spac_befr;
    }

    public void setProp_spac_befr(String prop_spac_befr) {
        this.prop_spac_befr = prop_spac_befr;
    }

    public String getDesc_spac() {
        return desc_spac;
    }

    public void setDesc_spac(String desc_spac) {
        this.desc_spac = desc_spac;
    }

    public String getTot_gust() {
        return tot_gust;
    }

    public void setTot_gust(String tot_gust) {
        this.tot_gust = tot_gust;
    }

    public String getRom_typ() {
        return rom_typ;
    }

    public void setRom_typ(String rom_typ) {
        this.rom_typ = rom_typ;
    }

    public int getRoom_num() {
        return room_num;
    }

    public void setRoom_num(int room_num) {
        this.room_num = room_num;
    }

    public int getBed_num() {
        return bed_num;
    }

    public void setBed_num(int bed_num) {
        this.bed_num = bed_num;
    }

    public String getBed_typ() {
        return bed_typ;
    }

    public void setBed_typ(String bed_typ) {
        this.bed_typ = bed_typ;
    }

    public int getMin_sty() {
        return min_sty;
    }

    public void setMin_sty(int min_sty) {
        this.min_sty = min_sty;
    }



    public String getContry() {
        return contry;
    }

    public void setContry(String contry) {
        this.contry = contry;
    }

    public String getStrt() {
        return strt;
    }

    public void setStrt(String strt) {
        this.strt = strt;
    }

    public String getApt_sut() {
        return apt_sut;
    }

    public void setApt_sut(String apt_sut) {
        this.apt_sut = apt_sut;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

    public String getZip_cod() {
        return zip_cod;
    }

    public void setZip_cod(String zip_cod) {
        this.zip_cod = zip_cod;
    }

    public Double getLatid() {
        return latid;
    }

    public void setLatid(Double latid) {
        this.latid = latid;
    }

    public Double getLongt() {
        return longt;
    }

    public void setLongt(Double longt) {
        this.longt = longt;
    }



    public int getTow_sop() {
        return tow_sop;
    }

    public void setTow_sop(int tow_sop) {
        this.tow_sop = tow_sop;
    }

    public int getWir_inter() {
        return wir_inter;
    }

    public void setWir_inter(int wir_inter) {
        this.wir_inter = wir_inter;
    }

    public int getShamp() {
        return shamp;
    }

    public void setShamp(int shamp) {
        this.shamp = shamp;
    }

    public int getHangr() {
        return hangr;
    }

    public void setHangr(int hangr) {
        this.hangr = hangr;
    }

    public int getTv() {
        return tv;
    }

    public void setTv(int tv) {
        this.tv = tv;
    }

    public int getHeat() {
        return heat;
    }

    public void setHeat(int heat) {
        this.heat = heat;
    }

    public int getAr_cond() {
        return ar_cond;
    }

    public void setAr_cond(int ar_cond) {
        this.ar_cond = ar_cond;
    }

    public int getBreak_cofe() {
        return break_cofe;
    }

    public void setBreak_cofe(int break_cofe) {
        this.break_cofe = break_cofe;
    }

    public int getSmk_det() {
        return smk_det;
    }

    public void setSmk_det(int smk_det) {
        this.smk_det = smk_det;
    }

    public int getCabon() {
        return cabon;
    }

    public void setCabon(int cabon) {
        this.cabon = cabon;
    }

    public int getFirs_aid() {
        return firs_aid;
    }

    public void setFirs_aid(int firs_aid) {
        this.firs_aid = firs_aid;
    }

    public int getSaft_card() {
        return saft_card;
    }

    public void setSaft_card(int saft_card) {
        this.saft_card = saft_card;
    }

    public int getFir_exting() {
        return fir_exting;
    }

    public void setFir_exting(int fir_exting) {
        this.fir_exting = fir_exting;
    }

    public int getKitch() {
        return kitch;
    }

    public void setKitch(int kitch) {
        this.kitch = kitch;
    }

    public int getLaudr_washr() {
        return laudr_washr;
    }

    public void setLaudr_washr(int laudr_washr) {
        this.laudr_washr = laudr_washr;
    }

    public int getLaudr_dryr() {
        return laudr_dryr;
    }

    public void setLaudr_dryr(int laudr_dryr) {
        this.laudr_dryr = laudr_dryr;
    }

    public int getFre_pac() {
        return fre_pac;
    }

    public void setFre_pac(int fre_pac) {
        this.fre_pac = fre_pac;
    }

    public int getElev() {
        return elev;
    }

    public void setElev(int elev) {
        this.elev = elev;
    }

    public int getPool() {
        return pool;
    }

    public void setPool(int pool) {
        this.pool = pool;
    }

    public int getHot_tub() {
        return hot_tub;
    }

    public void setHot_tub(int hot_tub) {
        this.hot_tub = hot_tub;
    }

    public int getGym() {
        return gym;
    }

    public void setGym(int gym) {
        this.gym = gym;
    }

    public String getAdv_not() {
        return adv_not;
    }

    public void setAdv_not(String adv_not) {
        this.adv_not = adv_not;
    }

    public String getResr_spac() {
        return resr_spac;
    }

    public void setResr_spac(String resr_spac) {
        this.resr_spac = resr_spac;
    }

    public String getReserv_requst() {
        return reserv_requst;
    }

    public void setReserv_requst(String reserv_requst) {
        this.reserv_requst = reserv_requst;
    }

    public String getArriv_aftr() {
        return arriv_aftr;
    }

    public void setArriv_aftr(String arriv_aftr) {
        this.arriv_aftr = arriv_aftr;
    }

    public String getArriv_befr() {
        return arriv_befr;
    }

    public void setArriv_befr(String arriv_befr) {
        this.arriv_befr = arriv_befr;
    }

    public String getLeav_befr() {
        return leav_befr;
    }

    public void setLeav_befr(String leav_befr) {
        this.leav_befr = leav_befr;
    }

    public String getGues_offn() {
        return gues_offn;
    }

    public void setGues_offn(String gues_offn) {
        this.gues_offn = gues_offn;
    }

    public String getSpec_offr() {
        return spec_offr;
    }

    public void setSpec_offr(String spec_offr) {
        this.spec_offr = spec_offr;
    }

    public String getPric() {
        return pric;
    }

    public void setPric(String pric) {
        this.pric = pric;
    }

    public String getCurncy() {
        return curncy;
    }

    public void setCurncy(String curncy) {
        this.curncy = curncy;
    }






}
