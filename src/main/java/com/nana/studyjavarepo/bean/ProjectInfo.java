package com.nana.studyjavarepo.bean;

/**
 * 机型项目类
 */
public class ProjectInfo {
    private String projectId;

    private String projectName;

    private String projectOuterName;

    private String projectStatus;

    private String riskLevel;

    private String projectType;

    private String hardwarePlatform;

    private String platformModel;

    private String leaderId;

    private String projectLeaderId;

    private String projectApprovalPeriod;

    private String projectApprovalStatus;

    private String bringupPeriod;

    private String bringupStatus;

    private String sdvPeriod;

    private String sdvStatus;

    private String mandatoryCertificationPeriod;

    private String mandatoryCertificationStatus;

    private String sitPeriod;

    private String sitStatus;

    private String networkTestPeriod;

    private String networkTestStatus;

    private String mptPeriod;

    private String mptStatus;

    private String lvtPeriod;

    private String lvtStatus;

    private String bz;

    private UserInfo leader;//总负责人
    private UserInfo projectLeader;//项目负责人

    public ProjectInfo(String projectId, String projectName, String projectOuterName, String projectStatus, String riskLevel, String projectType, String hardwarePlatform, String platformModel, String leaderId, String projectLeaderId, String projectApprovalPeriod, String projectApprovalStatus, String bringupPeriod, String bringupStatus, String sdvPeriod, String sdvStatus, String mandatoryCertificationPeriod, String mandatoryCertificationStatus, String sitPeriod, String sitStatus, String networkTestPeriod, String networkTestStatus, String mptPeriod, String mptStatus, String lvtPeriod, String lvtStatus, String bz) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.projectOuterName = projectOuterName;
        this.projectStatus = projectStatus;
        this.riskLevel = riskLevel;
        this.projectType = projectType;
        this.hardwarePlatform = hardwarePlatform;
        this.platformModel = platformModel;
        this.leaderId = leaderId;
        this.projectLeaderId = projectLeaderId;
        this.projectApprovalPeriod = projectApprovalPeriod;
        this.projectApprovalStatus = projectApprovalStatus;
        this.bringupPeriod = bringupPeriod;
        this.bringupStatus = bringupStatus;
        this.sdvPeriod = sdvPeriod;
        this.sdvStatus = sdvStatus;
        this.mandatoryCertificationPeriod = mandatoryCertificationPeriod;
        this.mandatoryCertificationStatus = mandatoryCertificationStatus;
        this.sitPeriod = sitPeriod;
        this.sitStatus = sitStatus;
        this.networkTestPeriod = networkTestPeriod;
        this.networkTestStatus = networkTestStatus;
        this.mptPeriod = mptPeriod;
        this.mptStatus = mptStatus;
        this.lvtPeriod = lvtPeriod;
        this.lvtStatus = lvtStatus;
        this.bz = bz;
    }

    public ProjectInfo() {
        super();
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId == null ? null : projectId.trim();
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName == null ? null : projectName.trim();
    }

    public String getProjectOuterName() {
        return projectOuterName;
    }

    public void setProjectOuterName(String projectOuterName) {
        this.projectOuterName = projectOuterName == null ? null : projectOuterName.trim();
    }

    public String getProjectStatus() {
        return projectStatus;
    }

    public void setProjectStatus(String projectStatus) {
        this.projectStatus = projectStatus == null ? null : projectStatus.trim();
    }

    public String getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(String riskLevel) {
        this.riskLevel = riskLevel == null ? null : riskLevel.trim();
    }

    public String getProjectType() {
        return projectType;
    }

    public void setProjectType(String projectType) {
        this.projectType = projectType == null ? null : projectType.trim();
    }

    public String getHardwarePlatform() {
        return hardwarePlatform;
    }

    public void setHardwarePlatform(String hardwarePlatform) {
        this.hardwarePlatform = hardwarePlatform == null ? null : hardwarePlatform.trim();
    }

    public String getPlatformModel() {
        return platformModel;
    }

    public void setPlatformModel(String platformModel) {
        this.platformModel = platformModel == null ? null : platformModel.trim();
    }

    public String getLeaderId() {
        return leaderId;
    }

    public void setLeaderId(String leaderId) {
        this.leaderId = leaderId == null ? null : leaderId.trim();
    }

    public String getProjectLeaderId() {
        return projectLeaderId;
    }

    public void setProjectLeaderId(String projectLeaderId) {
        this.projectLeaderId = projectLeaderId == null ? null : projectLeaderId.trim();
    }

    public String getProjectApprovalPeriod() {
        return projectApprovalPeriod;
    }

    public void setProjectApprovalPeriod(String projectApprovalPeriod) {
        this.projectApprovalPeriod = projectApprovalPeriod == null ? null : projectApprovalPeriod.trim();
    }

    public String getProjectApprovalStatus() {
        return projectApprovalStatus;
    }

    public void setProjectApprovalStatus(String projectApprovalStatus) {
        this.projectApprovalStatus = projectApprovalStatus == null ? null : projectApprovalStatus.trim();
    }

    public String getBringupPeriod() {
        return bringupPeriod;
    }

    public void setBringupPeriod(String bringupPeriod) {
        this.bringupPeriod = bringupPeriod == null ? null : bringupPeriod.trim();
    }

    public String getBringupStatus() {
        return bringupStatus;
    }

    public void setBringupStatus(String bringupStatus) {
        this.bringupStatus = bringupStatus == null ? null : bringupStatus.trim();
    }

    public String getSdvPeriod() {
        return sdvPeriod;
    }

    public void setSdvPeriod(String sdvPeriod) {
        this.sdvPeriod = sdvPeriod == null ? null : sdvPeriod.trim();
    }

    public String getSdvStatus() {
        return sdvStatus;
    }

    public void setSdvStatus(String sdvStatus) {
        this.sdvStatus = sdvStatus == null ? null : sdvStatus.trim();
    }

    public String getMandatoryCertificationPeriod() {
        return mandatoryCertificationPeriod;
    }

    public void setMandatoryCertificationPeriod(String mandatoryCertificationPeriod) {
        this.mandatoryCertificationPeriod = mandatoryCertificationPeriod == null ? null : mandatoryCertificationPeriod.trim();
    }

    public String getMandatoryCertificationStatus() {
        return mandatoryCertificationStatus;
    }

    public void setMandatoryCertificationStatus(String mandatoryCertificationStatus) {
        this.mandatoryCertificationStatus = mandatoryCertificationStatus == null ? null : mandatoryCertificationStatus.trim();
    }

    public String getSitPeriod() {
        return sitPeriod;
    }

    public void setSitPeriod(String sitPeriod) {
        this.sitPeriod = sitPeriod == null ? null : sitPeriod.trim();
    }

    public String getSitStatus() {
        return sitStatus;
    }

    public void setSitStatus(String sitStatus) {
        this.sitStatus = sitStatus == null ? null : sitStatus.trim();
    }

    public String getNetworkTestPeriod() {
        return networkTestPeriod;
    }

    public void setNetworkTestPeriod(String networkTestPeriod) {
        this.networkTestPeriod = networkTestPeriod == null ? null : networkTestPeriod.trim();
    }

    public String getNetworkTestStatus() {
        return networkTestStatus;
    }

    public void setNetworkTestStatus(String networkTestStatus) {
        this.networkTestStatus = networkTestStatus == null ? null : networkTestStatus.trim();
    }

    public String getMptPeriod() {
        return mptPeriod;
    }

    public void setMptPeriod(String mptPeriod) {
        this.mptPeriod = mptPeriod == null ? null : mptPeriod.trim();
    }

    public String getMptStatus() {
        return mptStatus;
    }

    public void setMptStatus(String mptStatus) {
        this.mptStatus = mptStatus == null ? null : mptStatus.trim();
    }

    public String getLvtPeriod() {
        return lvtPeriod;
    }

    public void setLvtPeriod(String lvtPeriod) {
        this.lvtPeriod = lvtPeriod == null ? null : lvtPeriod.trim();
    }

    public String getLvtStatus() {
        return lvtStatus;
    }

    public void setLvtStatus(String lvtStatus) {
        this.lvtStatus = lvtStatus == null ? null : lvtStatus.trim();
    }

    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz == null ? null : bz.trim();
    }

    public UserInfo getLeader() {
        return leader;
    }

    public void setLeader(UserInfo leader) {
        this.leader = leader;
    }

    public UserInfo getProjectLeader() {
        return projectLeader;
    }

    public void setProjectLeader(UserInfo projectLeader) {
        this.projectLeader = projectLeader;
    }
}