package pageGoogleObjectModel.service;

import pageGoogleObjectModel.Model.CalculatorData;

public class CalculatorDataCreator {

    public static final String NUMBER_OF_INSTANCES = "4";
    public static final String LIST_SERIES = "N1";
    public static final String VM_CLASS = "regular";
    public static final String INSTANCE_TYPE = "n1-standard-8";
    public static final String NUMBERS_OF_GROUPS = "1";
    public static final String TYPES_OF_GPU = "NVIDIA Tesla V100";
    public static final String REGION = "Frankfurt";
    public static final String LOCAL_SSD = "2x375";
    public static final String COMMITTED_USAGE = "1 Year";

    public static CalculatorData creatorCalculatorData(){
    return new CalculatorData(NUMBER_OF_INSTANCES, LIST_SERIES, VM_CLASS, INSTANCE_TYPE, NUMBERS_OF_GROUPS, TYPES_OF_GPU, REGION, LOCAL_SSD, COMMITTED_USAGE);
    }

}
