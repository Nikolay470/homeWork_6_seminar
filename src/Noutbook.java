class Noutbook {
    private String brand;
    private String model;
    private Float screenDiagonal;
    private String CPUBrand;
    private String CPUModel;
    private Integer volumRAM;
    private Integer volumSSD;
    private boolean videoCard;
    private String videoCardModel;
    private Integer price;

    Noutbook (String brand, String model, Float screenDiagonal,
              String CPUBrand, String CPUModel, Integer volumRAM, Integer volumSSD,
              boolean videoCard, String videoCardModel, Integer price)
    {
        this.brand = brand;
        this.model = model;
        this.screenDiagonal = screenDiagonal;
        this.CPUBrand = CPUBrand;
        this.CPUModel = CPUModel;
        this.volumRAM = volumRAM;
        this.volumSSD = volumSSD;
        this.videoCard = videoCard;
        this.videoCardModel = videoCardModel;
        this.price = price;
    }

    public String getBrand(){
        return this.brand;
    }
    public String getModel(){
        return this.model;
    }
    public Float getScreenDiagonal(){
        return this.screenDiagonal;
    }
    public String getCPUBrand(){
        return this.CPUBrand;
    }
    public String getCPUModel(){
        return this.CPUModel;
    }
    public Integer getVolumRAM(){
        return this.volumRAM;
    }
    public Integer getVolumSSD(){
        return this.volumSSD;
    }
    public boolean isVedeoCard(){
        return this.videoCard;
    }
    public String getVideoCardModel(){ return this.videoCardModel; }
    public Integer getPrice(){ return this.price; }

    @Override
    public boolean equals(Object obj){
        if (obj instanceof Noutbook){
            Noutbook objNout = (Noutbook) obj;
            return this.model.equals(objNout.getModel())
                    && this.CPUModel.equals(objNout.getCPUModel())
                    && this.screenDiagonal.equals(objNout.getScreenDiagonal())
                    && this.volumRAM.equals(objNout.getVolumRAM())
                    && this.volumSSD.equals(objNout.getVolumSSD())
                    && this.videoCardModel.equals(objNout.getVideoCardModel())
                    && this.price.equals(objNout.getPrice());
        } else {
            return false;
        }
    }
    @Override
    public int hashCode(){
        return (this.brand.hashCode() + this.model.hashCode() +
                this.screenDiagonal.hashCode() + this.CPUBrand.hashCode() +
                this.CPUModel.hashCode() + this.volumRAM.hashCode() +
                this.volumSSD.hashCode() + this.videoCardModel.hashCode() +
                this.price.hashCode()) >> 4;
    }
}
