//package com.aurionpro.cashpro.commons.charges.bo;
//
//import java.util.LinkedHashSet;
//import java.util.Set;
//
//import com.aurionpro.cashpro.commons.bo.Child;
//import com.aurionpro.cashpro.commons.bo.Parent;
//import com.aurionpro.cashpro.commons.bo.ParentChildMakerCheckerBO;
//import com.aurionpro.cashpro.commons.charges.MeasureType;
//import com.aurionpro.cashpro.commons.charges.core.ChargeStrategyType;
//import com.aurionpro.cashpro.commons.charges.core.ChargeableType;
//import com.aurionpro.cashpro.commons.charges.dto.ChargeStrategyDTO;
//import com.aurionpro.cashpro.commons.dto.BaseDTO;
//
//public class ChargeStrategyBO extends ParentChildMakerCheckerBO {
//	
//	//TODO: Reflect these changes in HBM.
//	private Long chargeActivitySetupId;
//	private ChargeStrategyType strategyType = ChargeStrategyType.FIXED;
//	private MeasureType measureType = MeasureType.VALUE;
//	private ChargeableType chargeableType = ChargeableType.UNIT;
//	private Boolean processUnitsForGroup = true;
//	private double taxRate = 0;
//	private String taxCode;
//	
//	@Parent(ChargeableActivitySetUpBO.class)
//	private ChargeableActivitySetUpBO parentBO;
//	
//	@Child(ChargeStrategyDetailBO.class)
//	private Set<ChargeStrategyDetailBO> chargeStrategyDetails = new LinkedHashSet<ChargeStrategyDetailBO>();
//
//	public ChargeStrategyBO() {
//		super();
//	}
//	public ChargeStrategyBO(BaseDTO dto) {
//		super(dto);
//	}
//
//	public Set<ChargeStrategyDetailBO> getChargeStrategyDetails() {
//		return chargeStrategyDetails;
//	}
//
//	public void setChargeStrategyDetails(
//			Set<ChargeStrategyDetailBO> chargeStrategyDetails) {
//		this.chargeStrategyDetails = chargeStrategyDetails;
//	}
//
//	public ChargeStrategyType getStrategyType() {
//		return strategyType;
//	}
//
//	public void setStrategyType(ChargeStrategyType chargeStrategyType) {
//		this.strategyType = chargeStrategyType;
//	}
//	
//	@Override
//	protected BaseDTO createDTO() {
//		return new ChargeStrategyDTO("" + id);
//	}
//
//	public MeasureType getMeasureType() {
//		return measureType;
//	}
//
//	public void setMeasureType(MeasureType measureType) {
//		this.measureType = measureType;
//	}
//
//	public ChargeableType getChargeableType() {
//		return chargeableType;
//	}
//
//	public void setChargeableType(ChargeableType chargeableType) {
//		this.chargeableType = chargeableType;
//	}
//
//	public ChargeableActivitySetUpBO getParentBO() {
//		return parentBO;
//	}
//
//	public void setParentBO(ChargeableActivitySetUpBO parentBO) {
//		this.parentBO = parentBO;
//	}
//
//	public double getTaxRate() {
//		return taxRate;
//	}
//
//	public void setTaxRate(double taxRate) {
//		this.taxRate = taxRate;
//	}
//
//	public String getTaxCode() {
//		return taxCode;
//	}
//
//	public void setTaxCode(String taxCode) {
//		this.taxCode = taxCode;
//	}
//	
//	public Boolean getProcessUnitsForGroup() {
//		return processUnitsForGroup;
//	}
//
//	public void setProcessUnitsForGroup(Boolean processUnitsForGroup) {
//		this.processUnitsForGroup = processUnitsForGroup;
//	}
//	public Long getChargeActivitySetupId() {
//		try {
//			if (parentBO != null) {
//				chargeActivitySetupId = parentBO.getId();
//			}
//		} catch (Exception e) {
//		}
//		return chargeActivitySetupId;
//	}
//	public void setChargeActivitySetupId(Long chargeActivitySetupId) {
//		if(parentBO != null) {
//			this.chargeActivitySetupId = parentBO.getId();
//		}
//		else {
//			this.chargeActivitySetupId = chargeActivitySetupId;
//		}
//	}
//
//}
