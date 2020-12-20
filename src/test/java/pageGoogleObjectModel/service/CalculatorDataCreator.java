package pageGoogleObjectModel.service;

import pageGoogleObjectModel.Model.CalculatorData;

public class CalculatorDataCreator {

    public static final String NUMBER_OF_INSTANCES = "testdata.number.of.instances";
    public static final String LIST_SERIES = "testdata.list.series";
    public static final String VM_CLASS = "testdata.vm.class";
    public static final String INSTANCE_TYPE = "testdata.instance.type";
    public static final String NUMBERS_OF_GROUPS = "testdata.number.of.group";
    public static final String TYPES_OF_GPU = "testdata.types.of.gpu";
    public static final String REGION = "testdata.region";
    public static final String LOCAL_SSD = "testdata.local.ssd";
    public static final String COMMITTED_USAGE = "testdata.committed.usage";

    public static CalculatorData creatorCalculatorData(){
    return new CalculatorData(TestDataReader.getTestData(NUMBER_OF_INSTANCES),
            TestDataReader.getTestData(LIST_SERIES),
            TestDataReader.getTestData(VM_CLASS),
            TestDataReader.getTestData(INSTANCE_TYPE),
            TestDataReader.getTestData(NUMBERS_OF_GROUPS),
            TestDataReader.getTestData(TYPES_OF_GPU),
            TestDataReader.getTestData(REGION),
            TestDataReader.getTestData(LOCAL_SSD),
            TestDataReader.getTestData(COMMITTED_USAGE));
    }

}
