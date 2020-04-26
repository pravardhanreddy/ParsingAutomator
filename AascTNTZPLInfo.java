package com.aasc.model;

import java.util.LinkedList;//oct_5_2017

/* ========================================================================================
   Date        Resource         Change history
   ------------------------------------------------------------------------------------------
   18/10/2019  Eshwari M     Added setters and getters for TNT Routing label fields
   09/01/2020  Vathsalya     Modified DataTypes and added few fields
   ========================================================================================*/

public class AascTNTZPLInfo {
    public AascTNTZPLInfo() {
    }
    
    private String shipmentDate;
    private String senderAccount;
    private String collDepo;

    private String connumber;
    private String service;
    private String serviceShotName;
    private String goodsDesc1 ;
    private String deliveryInst;

    private double length;
    private double width;
    private double height;
    private double weight;
    private String weightUOM;
    private String unitsUOM;
    private double volume;
    private String volumeUOM;

    private String receiverCompanyName;
    private String receiverStreet1;
    private String receiverStreet2;
    private String receiverStreet3;
    private String receiverCity;
    private String receiverProvince ;
    private String receiverPostCode ;
    private String receiverCountry ;
    private String receiverContactName ;
    private String receiverContactDialCode;
    private String receiverContactTelephone;
    private String receiverContactEmail ;
    private String receiverAccount ;
    
    private String senderCompanyName;
    private String senderStreet1;
    private String senderStreet2;
    private String senderStreet3;
    private String senderCity;
    private String senderProvince ;
    private String senderPostCode ;
    private String senderCountry ;
    private String senderContactName ;
    private String senderContactDialCode;
    private String senderContactTelephone;
    private String senderContactEmail ;
    private String wayBillNumber;
    private String trackingNumber;
    
    private String collectionDepotName;
    private String collectionDepotCode;
    private String deliveryDepotName;   
    private String deliveryDepotCode; 
    
    
    private String statCode;
    
    private double totalWeight;
    private int totalItemNumber;
    private int packageNumber;  
    private String currency;
    private String totalItem;
    private double goodsValue;
    
    private String insuranceValue;
    private double totalVolume;
    private String paymentType;
    private String conRef;
    private String customerRef;//7.2.3.4.13 change
    LinkedList dimenstionList;
    private String dangerousGoods;

    public void setShipmentDate(String shipmentDate) {
        this.shipmentDate = shipmentDate;
    }

    public String getShipmentDate() {
        return shipmentDate;
    }

    public void setSenderAccount(String senderAccount) {
        this.senderAccount = senderAccount;
    }

    public String getSenderAccount() {
        return senderAccount;
    }

    public void setCollDepo(String collDepo) {
        this.collDepo = collDepo;
    }

    public String getCollDepo() {
        return collDepo;
    }

    public void setConnumber(String connumber) {
        this.connumber = connumber;
    }

    public String getConnumber() {
        return connumber;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getService() {
        return service;
    }

    public String getServiceShotName() {
		    return serviceShotName;
  	}

	  public void setServiceShotName(String serviceShotName) {
		    this.serviceShotName = serviceShotName;
	  }

	  public void setGoodsDesc1(String goodsDesc1) {
        this.goodsDesc1 = goodsDesc1;
    }

    public String getGoodsDesc1() {
        return goodsDesc1;
    }

    public void setDeliveryInst(String deliveryInst) {
        this.deliveryInst = deliveryInst;
    }

    public String getDeliveryInst() {
        return deliveryInst;
    }

  

    public void setReceiverCompanyName(String receiverCompanyName) {
        this.receiverCompanyName = receiverCompanyName;
    }

    public String getReceiverCompanyName() {
        return receiverCompanyName;
    }

    public void setReceiverStreet1(String receiverStreet1) {
        this.receiverStreet1 = receiverStreet1;
    }

    public String getReceiverStreet1() {
        return receiverStreet1;
    }

    public void setReceiverStreet2(String receiverStreet2) {
        this.receiverStreet2 = receiverStreet2;
    }

    public String getReceiverStreet2() {
        return receiverStreet2;
    }

    public void setReceiverStreet3(String receiverStreet3) {
        this.receiverStreet3 = receiverStreet3;
    }

    public String getReceiverStreet3() {
        return receiverStreet3;
    }

    public void setReceiverCity(String receiverCity) {
        this.receiverCity = receiverCity;
    }

    public String getReceiverCity() {
        return receiverCity;
    }

    public void setReceiverProvince(String receiverProvince) {
        this.receiverProvince = receiverProvince;
    }

    public String getReceiverProvince() {
        return receiverProvince;
    }

    public void setReceiverPostCode(String receiverPostCode) {
        this.receiverPostCode = receiverPostCode;
    }

    public String getReceiverPostCode() {
        return receiverPostCode;
    }

    public void setReceiverCountry(String receiverCountry) {
        this.receiverCountry = receiverCountry;
    }

    public String getReceiverCountry() {
        return receiverCountry;
    }

    public void setReceiverContactName(String receiverContactName) {
        this.receiverContactName = receiverContactName;
    }

    public String getReceiverContactName() {
        return receiverContactName;
    }

    public void setReceiverContactDialCode(String receiverContactDialCode) {
        this.receiverContactDialCode = receiverContactDialCode;
    }

    public String getReceiverContactDialCode() {
        return receiverContactDialCode;
    }

    public void setReceiverContactTelephone(String receiverContactTelephone) {
        this.receiverContactTelephone = receiverContactTelephone;
    }

    public String getReceiverContactTelephone() {
        return receiverContactTelephone;
    }

    public void setReceiverContactEmail(String receiverContactEmail) {
        this.receiverContactEmail = receiverContactEmail;
    }

    public String getReceiverContactEmail() {
        return receiverContactEmail;
    }

    public void setReceiverAccount(String receiverAccount) {
        this.receiverAccount = receiverAccount;
    }

    public String getReceiverAccount() {
        return receiverAccount;
    }

    public void setTotalItemNumber(int totalItemNumber) {
        this.totalItemNumber = totalItemNumber;
    }

    public int getTotalItemNumber() {
        return totalItemNumber;
    }

    public void setPackageNumber(int packageNumber) {
        this.packageNumber = packageNumber;
    }

    public int getPackageNumber() {
        return packageNumber;
    }

    public void setSenderCompanyName(String senderCompanyName) {
        this.senderCompanyName = senderCompanyName;
    }

    public String getSenderCompanyName() {
        return senderCompanyName;
    }

    public void setSenderStreet1(String senderStreet1) {
        this.senderStreet1 = senderStreet1;
    }

    public String getSenderStreet1() {
        return senderStreet1;
    }

    public void setSenderStreet2(String senderStreet2) {
        this.senderStreet2 = senderStreet2;
    }

    public String getSenderStreet2() {
        return senderStreet2;
    }

    public void setSenderStreet3(String senderStreet3) {
        this.senderStreet3 = senderStreet3;
    }

    public String getSenderStreet3() {
        return senderStreet3;
    }

    public void setSenderCity(String senderCity) {
        this.senderCity = senderCity;
    }

    public String getSenderCity() {
        return senderCity;
    }

    public void setSenderProvince(String senderProvince) {
        this.senderProvince = senderProvince;
    }

    public String getSenderProvince() {
        return senderProvince;
    }

    public void setSenderPostCode(String senderPostCode) {
        this.senderPostCode = senderPostCode;
    }

    public String getSenderPostCode() {
        return senderPostCode;
    }

    public void setSenderCountry(String senderCountry) {
        this.senderCountry = senderCountry;
    }

    public String getSenderCountry() {
        return senderCountry;
    }

    public void setSenderContactName(String senderContactName) {
        this.senderContactName = senderContactName;
    }

    public String getSenderContactName() {
        return senderContactName;
    }

    public void setSenderContactDialCode(String senderContactDialCode) {
        this.senderContactDialCode = senderContactDialCode;
    }

    public String getSenderContactDialCode() {
        return senderContactDialCode;
    }

    public void setSenderContactTelephone(String senderContactTelephone) {
        this.senderContactTelephone = senderContactTelephone;
    }

    public String getSenderContactTelephone() {
        return senderContactTelephone;
    }

    public void setSenderContactEmail(String senderContactEmail) {
        this.senderContactEmail = senderContactEmail;
    }

    public String getSenderContactEmail() {
        return senderContactEmail;
    }

    public void setWayBillNumber(String wayBillNumber) {
        this.wayBillNumber = wayBillNumber;
    }

    public String getWayBillNumber() {
        return wayBillNumber;
    }

    public void setCollectionDepotName(String collectionDepotName) {
        this.collectionDepotName = collectionDepotName;
    }

    public String getCollectionDepotName() {
        return collectionDepotName;
    }

    public void setCollectionDepotCode(String collectionDepotCode) {
        this.collectionDepotCode = collectionDepotCode;
    }

    public String getCollectionDepotCode() {
        return collectionDepotCode;
    }

    public void setDeliveryDepotName(String deliveryDepotName) {
        this.deliveryDepotName = deliveryDepotName;
    }

    public String getDeliveryDepotName() {
        return deliveryDepotName;
    }

    

  
    public void setLength(Double length) {
        this.length = length;
    }

    public Double getLength() {
        return length;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public Double getWidth() {
        return width;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getHeight() {
        return height;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeightUOM(String weightUOM) {
        this.weightUOM = weightUOM;
    }

    public String getWeightUOM() {
        return weightUOM;
    }

    public void setUnitsUOM(String unitsUOM) {
        this.unitsUOM = unitsUOM;
    }

    public String getUnitsUOM() {
        return unitsUOM;
    }

    public void setStatCode(String statCode) {
        this.statCode = statCode;
    }

    public String getStatCode() {
        return statCode;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCurrency() {
        return currency;
    }

    

    public void setGoodsValue(double goodsValue) {
        this.goodsValue = goodsValue;
    }

    public double getGoodsValue() {
        return goodsValue;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public void setDeliveryDepotCode(String deliveryDepotCode) {
        this.deliveryDepotCode = deliveryDepotCode;
    }

    public String getDeliveryDepotCode() {
        return deliveryDepotCode;
    }

    public void setInsuranceValue(String insuranceValue) {
        this.insuranceValue = insuranceValue;
    }

    public String getInsuranceValue() {
        return insuranceValue;
    }

    public void setTotalVolume(double totalVolume) {
        this.totalVolume = totalVolume;
    }

    public double getTotalVolume() {
        return totalVolume;
    }

    public void setTotalWeight(double totalWeight) {
        this.totalWeight = totalWeight;
    }

    public double getTotalWeight() {
        return totalWeight;
    }

    public void setTotalItem(String totalItem) {
        this.totalItem = totalItem;
    }

    public String getTotalItem() {
        return totalItem;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getPaymentType() {
        return paymentType;
    }
    public String getConRef() {
		    return conRef;
	  }

	  public void setConRef(String conRef) {
		    this.conRef = conRef;
	  }

	//7.2.3.4.13 change
    public void setCustomerRef(String customerRef) {
        this.customerRef = customerRef;
    }

    public String getCustomerRef() {
        return customerRef;
    }

    public void setDimenstionList(LinkedList dimenstionList) {
        this.dimenstionList = dimenstionList;
    }

    public LinkedList getDimenstionList() {
        return dimenstionList;
    }

	public String getDangerousGoods() {
		return dangerousGoods;
	}

	public void setDangerousGoods(String dangerousGoods) {
		this.dangerousGoods = dangerousGoods;
	}

	public double getVolume() {
		return volume;
	}

	public void setVolume(double volume) {
		this.volume = volume;
	}

	public String getVolumeUOM() {
		return volumeUOM;
	}

	public void setVolumeUOM(String volumeUOM) {
		this.volumeUOM = volumeUOM;
	}
}
