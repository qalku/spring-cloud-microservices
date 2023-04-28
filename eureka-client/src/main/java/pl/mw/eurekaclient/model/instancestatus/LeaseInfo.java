package pl.mw.eurekaclient.model.instancestatus;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class LeaseInfo {
    private LeaseInfo leaseInfo;
    /*
    <renewalIntervalInSecs>30</renewalIntervalInSecs>
<durationInSecs>90</durationInSecs>
<registrationTimestamp>1672871537765</registrationTimestamp>
<lastRenewalTimestamp>1672871537765</lastRenewalTimestamp>
<evictionTimestamp>0</evictionTimestamp>
<serviceUpTimestamp>1672871536953</serviceUpTimestamp>
     */
    private String renewalIntervalInSecs;
    private String durationInSecs;
    private Object registrationTimestamp;
    private Object lastRenewalTimestamp;
    private Object evictionTimestamp;
    private Object serviceUpTimestamp;
}
