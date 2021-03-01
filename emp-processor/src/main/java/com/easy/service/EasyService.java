package com.easy.service;



/**
 * @Packge
 * @Autor linNaibin
 * @Description 模型算法service
 * @Version 1.0
 * @Date 2020/11/30 14:42
 */
public interface EasyService {
    //纳税能力
    public static final String TAX_ABILITY_SERVICE_NAME = "TaxAbilityService";
    // 创新能力
    public static final String INNOVATE_ABILITY_SERVICE_NAME = "InnovateAbilityService";
    //资金实力
    public static final String CAPITAL_ABILITY_SERVICE_NAME = "CapitalAbilityService";
    //资金增长能力
    public static final String BUSINESS_ABILITY_SERVICE_NAME = "BusinessAbilityService";
    //资质荣誉得分
    public static final String APTITUDE_SERVICE_NAME = "AptitudeService";
    //人才贡献
    public static final String TALENT_CONTRIBUTE_SERVICE_NAME = "TalentContributeService";
    //企业风险
    public static final String ENTERPRISE_RISK_SERVICE_NAME = "EnterpriseRiskService";
    //风险舆情
    public static final String RISK_OPINION_SERVICE_NAME = "RiskOpinionService";
    //管理风险
    public static final String MANAGE_RISK_SERVICE_NAME = "ManageRiskService";
    //企业司法风险
    public static final String JUDICIAL_RISK_SERVICE_NAME = "JudicialRiskService";
    //企业变更风险
    public static final String CHANGE_RISK_SERVICE_NAME = "ChangeRiskService";

    void free();
}
