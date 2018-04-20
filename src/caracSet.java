import org.json.JSONObject;

/*
* Class of all the caracteristics of a race or a character
* */
public class caracSet {
    private int str = 10;
    private int dex = 10;
    private int con = 10;
    private int intel = 10;
    private int wis = 10;
    private int cha = 10;

    //Constructor with a JSON set with all the caracs
    public caracSet(String jsonCarac) {
        JSONObject obj = new JSONObject(jsonCarac);
        this.str = obj.getInt("str");
        this.dex = obj.getInt("dex");
        this.con = obj.getInt("con");
        this.intel = obj.getInt("intel");
        this.wis = obj.getInt("wis");
        this.cha = obj.getInt("cha");
    }

    //Constructor with all the caracs provided
    public caracSet(int _str, int _dex, int _con, int _intel, int _wis, int _cha) {
        this.str = _str;
        this.dex = _dex;
        this.con = _con;
        this.intel = _intel;
        this.wis = _wis;
        this.cha = _cha;
    }

    //Return a JSON with all the caracs in it
    @Override
    public String toString() {
        return toJSON();
    }

    //Return a JSON with all the caracs in it
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

    //Add two carac set because the java can't handle +operator overload
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

    //Getters
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

    //Setters, a carac can't be bellow zero otherwise it will throw CaracUnderZeroException
    public void setCha(int cha) throws CaracUnderOneException {
        if (cha < 1)
            throw new CaracUnderOneException();
        else
            this.cha = cha;
    }

    public void setCon(int con) throws CaracUnderOneException  {
        if (con < 1)
            throw new CaracUnderOneException();
        else
            this.con = con;
    }

    public void setDex(int dex) throws CaracUnderOneException  {
        if (dex < 1)
            throw new CaracUnderOneException();
        else
            this.dex = dex;
    }

    public void setIntel(int intel) throws CaracUnderOneException  {
        if (intel < 1)
            throw new CaracUnderOneException();
        else
            this.intel = intel;
    }

    public void setStr(int str) throws CaracUnderOneException  {
        if (str < 1)
            throw new CaracUnderOneException();
        else
            this.str = str;
    }

    public void setWis(int wis) throws CaracUnderOneException  {
        if (wis < 1)
            throw new CaracUnderOneException();
        else
            this.wis = wis;
    }
}
