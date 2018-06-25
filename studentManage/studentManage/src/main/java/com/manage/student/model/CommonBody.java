package com.manage.student.model;

public class CommonBody {
    private String id;

    private String username;

    private String password;

    private String profession;

    private String classAndGrade;

    private String realname;

    private String sex;

    private int level;

    private int height;

    private int weight;

    private int vitalCapacity;

    private int chestCircumference;

    private String leftEye;

    private String rigthEye;

    private String remark;

    private int currentPage;

    private int totalItems;

    private int itemsPerPage;

    private ShenGao shenGao;

    private TiZhong tiZhong;

    private XiongWei xiongWei;

    private FeiHuoLiang feiHuoLiang;

    public TiZhong getTiZhong() {
        return tiZhong;
    }

    public void setTiZhong(TiZhong tiZhong) {
        this.tiZhong = tiZhong;
    }

    public XiongWei getXiongWei() {
        return xiongWei;
    }

    public void setXiongWei(XiongWei xiongWei) {
        this.xiongWei = xiongWei;
    }

    public FeiHuoLiang getFeiHuoLiang() {
        return feiHuoLiang;
    }

    public void setFeiHuoLiang(FeiHuoLiang feiHuoLiang) {
        this.feiHuoLiang = feiHuoLiang;
    }

    public ShenGao getShenGao() {
        return shenGao;
    }

    public void setShenGao(ShenGao shenGao) {
        this.shenGao = shenGao;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getClassAndGrade() {
        return classAndGrade;
    }

    public void setClassAndGrade(String classAndGrade) {
        this.classAndGrade = classAndGrade;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }


    public int getVitalCapacity() {
        return vitalCapacity;
    }

    public void setVitalCapacity(int vitalCapacity) {
        this.vitalCapacity = vitalCapacity;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getChestCircumference() {
        return chestCircumference;
    }

    public void setChestCircumference(int chestCircumference) {
        this.chestCircumference = chestCircumference;
    }

    public int getHeight() {

        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getLeftEye() {
        return leftEye;
    }

    public void setLeftEye(String leftEye) {
        this.leftEye = leftEye;
    }

    public String getRigthEye() {
        return rigthEye;
    }

    public void setRigthEye(String rigthEye) {
        this.rigthEye = rigthEye;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }


    public int getItemsPerPage() {
        return itemsPerPage;
    }

    public void setItemsPerPage(int itemsPerPage) {
        this.itemsPerPage = itemsPerPage;
    }

    public int getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(int totalItems) {
        this.totalItems = totalItems;
    }
}
