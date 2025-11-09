public class RecurringTask extends Task{
    private String dataStart;
    private byte isnterval;

    public String getDataStart() {return dataStart;}
    public byte getIsnterval() {return isnterval;}

    public void setIsnterval(byte isnterval) {
        this.isnterval = isnterval;
    }

    public void setDataStart(String dataStart) {
        this.dataStart = dataStart;
    }
}
