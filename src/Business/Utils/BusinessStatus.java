/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Utils;

/**
 *
 * @author Floyed Pinto
 */
public enum BusinessStatus {
    All("ALL"),
    
    Submitted("Submitted"),
    BckgrdChkReq("Background check requested"),
    BckgrdChkApp("Background check approved"),
    BckgrdChkRej("Background check rejected"),
    Advertised("Advertised"),
    InProgress("In progress"),
    Fulfilled("Fulfilled"),
    UnFulfilled("UnFulfilled"),
    ReadyToPick("Ready to pick"),
    VInProgress("Volunteer work in progress"),
    VFulfilled("Volunteer work fulfilled"),
    VUnfulfilled("Volunteer work unfulfilled");

    private String value;

    private BusinessStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }

}
