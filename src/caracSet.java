import org.json.JSONObject;

public class caracSet {
    private int str = 10;
    private int dex = 10;
    private int con = 10;
    private int intel = 10;
    private int wis = 10;
    private int cha = 10;

    public caracSet(String jsonCarac) {
        JSONObject obj = new JSONObject(jsonCarac);
        this.str = obj.getInt("str");
        this.dex = obj.getInt("dex");
        this.con = obj.getInt("con");
        this.intel = obj.getInt("intel");
        this.wis = obj.getInt("wis");
        this.cha = obj.getInt("cha");
    }

    public caracSet(int _str, int _dex, int _con, int _intel, int _wis, int _cha) {
        this.str = _str;
        this.dex = _dex;
        this.con = _con;
        this.intel = _intel;
        this.wis = _wis;
        this.cha = _cha;
    }

    @Override
    public String toString() {
        //return "Charac set : \n str : " + this.str + "\n dex : " + this.dex + "\n con : " + this.con + "\n intel : " + this.intel + "\n wis : " + this.wis + "\n cha : " + this.cha;
        return toJSON();
    }

    public String toJSON() {
        JSONObject obj = new JSONObject("{}");
        obj.put("str", new Integer(this.str));
        obj.put("dex", new Integer(this.dex));
        obj.put("con", new Integer(this.con));
        obj.put("intel", new Integer(this.intel));
        obj.put("wis", new Integer(this.wis));
        obj.put("cha", new Integer(this.cha));
        return obj.toString();
    }

    public caracSet add(caracSet confront) {
        return new caracSet(
                this.str + confront.getStr(),
                this.dex + confront.getDex(),
                this.con + confront.getCon(),
                this.intel + confront.getIntel(),
                this.wis + confront.getWis(),
                this.cha + confront.getCha()
        );
    }

    public int getCha() {
        return cha;
    }

    public int getCon() {
        return con;
    }

    public int getDex() {
        return dex;
    }

    public int getIntel() {
        return intel;
    }

    public int getStr() {
        return str;
    }

    public int getWis() {
        return wis;
    }

    public void setCha(int cha) {
        if (cha < 1)
            this.cha = 1;
        else
            this.cha = cha;
    }

    public void setCon(int con) {
        if (con < 1)
            this.con = 1;
        else
            this.con = con;
    }

    public void setDex(int dex) {
        if (dex < 1)
            this.dex = 1;
        else
            this.dex = dex;
    }

    public void setIntel(int intel) {
        if (intel < 1)
            this.intel = 1;
        else
            this.intel = intel;
    }

    public void setStr(int str) {
        if (str < 1)
            this.str = 1;
        else
            this.str = str;
    }

    public void setWis(int wis) {
        if (wis < 1)
            this.wis = 1;
        else
            this.wis = wis;
    }
}
