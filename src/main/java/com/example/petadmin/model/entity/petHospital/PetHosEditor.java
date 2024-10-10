package com.example.petadmin.model.entity.petHospital;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class PetHosEditor {

    private BigDecimal hosLatitude;
    private BigDecimal hosLongitude;
    private String hospitalAddr;
    private String hospitalName;
    private String hospitalNum;
    private String sigunName;
    private String operState;

    @Builder
    public PetHosEditor(BigDecimal hosLatitude, BigDecimal hosLongitude, String hospitalAddr,
                        String hospitalName, String hospitalNum, String operState,String sigunName){
        this.hosLatitude = hosLatitude;
        this.hosLongitude = hosLongitude;
        this.hospitalAddr = hospitalAddr;
        this.hospitalName = hospitalName;
        this.hospitalNum = hospitalNum;
        this.operState = operState;
        this.sigunName = sigunName;
    }

    public static class PetHosEditorBuilder {
        private BigDecimal hosLatitude;
        private BigDecimal hosLongitude;
        private String hospitalAddr;
        private String hospitalName;
        private String hospitalNum;
        private String operState;
        private String sigunName;

        PetHosEditorBuilder() {
        }

        public PetHosEditorBuilder hosLatitude(final BigDecimal hosLatitude) {
            if(hosLatitude != null) {
                this.hosLatitude = hosLatitude;
            }
            return this;
        }

        public PetHosEditorBuilder hosLongitude(final BigDecimal hosLongitude) {
            if(hosLongitude != null) {
                this.hosLongitude = hosLongitude;
            }
            return this;
        }

        public PetHosEditorBuilder hospitalAddr(final String hospitalAddr) {
            if(hospitalAddr != null) {
                    this.hospitalAddr = hospitalAddr;
            }
            return this;
        }

        public PetHosEditorBuilder hospitalName(final String hospitalName) {
            if(hospitalName != null) {
                this.hospitalName = hospitalName;
            }
            return this;
        }

        public PetHosEditorBuilder hospitalNum(final String hospitalNum) {
            if(hospitalNum != null) {
                this.hospitalNum = hospitalNum;
            }
            return this;
        }

        public PetHosEditorBuilder operState(final String operState) {
            if(operState != null) {
                this.operState = operState;
            }
            return this;
        }

        public PetHosEditorBuilder sigunName(final String sigunName) {
            if(sigunName != null) {
                this.sigunName = sigunName;
            }
            return this;
        }

        public PetHosEditor build() {
            return new PetHosEditor(this.hosLatitude, this.hosLongitude, this.hospitalAddr, this.hospitalName, this.hospitalNum, this.operState, this.sigunName);
        }

        public String toString() {
            return "PetHosEditor.PetHosEditorBuilder(hosLatitude=" + this.hosLatitude + ", hosLongitude=" + this.hosLongitude + ", hospitalAddr=" + this.hospitalAddr + ", hospitalName=" + this.hospitalName + ", hospitalNum=" + this.hospitalNum + ", operState=" + this.operState + ", sigunName=" + this.sigunName + ")";
        }
    }
}
