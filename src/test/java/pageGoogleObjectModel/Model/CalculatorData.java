package pageGoogleObjectModel.Model;
import lombok.*;

@Getter
@Setter
@ToString
public class CalculatorData {

    private String numberOfInstances;
    private String series;
    private String vmClass;
    private String instanceType;
    private String numbersOfGroups;
    private String typesOfGpu;
    private String region;
    private String localSsd;
    private String committedUsage;

    public CalculatorData(String numberOfInstances, String series, String vmClass, String instanceType, String numbersOfGroups, String typesOfGpu, String region, String localSsd, String committedUsage) {
        this.numberOfInstances = numberOfInstances;
        this.series = series;
        this.vmClass = vmClass;
        this.instanceType = instanceType;
        this.numbersOfGroups = numbersOfGroups;
        this.typesOfGpu = typesOfGpu;
        this.region = region;
        this.localSsd = localSsd;
        this.committedUsage = committedUsage;
    }

}
