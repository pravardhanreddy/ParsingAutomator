public void generateManifestConnote(String response,
                                    AascDeliveryInfo aascDeliveryInfo,
                                    AascProfileOptionsInfo aascProfileOptionsInfo,
                                    String connoteStr,
                                    String timeStampStr) {

    logger.info("Entered generateManifestConnote() Method \n"+connoteStr);

    DOMParser parser = null;
    StringReader reader = null;
    InputSource input = null;
    XMLDocument xmlDocument = null;
    XMLElement root = null;

    try {
        parser = new DOMParser();

        // create InputSource from string containing XML response
        reader = new StringReader(response);
        input = new InputSource(reader);

        // Set various parser options: validation off, warnings shown
        parser.setValidationMode(false);
        parser.showWarnings(true);
        parser.parse(input);
        xmlDocument = parser.getDocument();

        // Print or extract document fields
        root = (XMLElement) xmlDocument.getDocumentElement();

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();

        // parse using builder to get DOM representation of the XML file
        Document dom = db.parse(new InputSource(new StringReader(response)));
        Element docEle = dom.getDocumentElement();
        // Manisha modified code for connote reponse

        Node marketTypeNode = root.selectSingleNode("/CONSIGNMENTBATCH/CONSIGNMENT").getAttributes().getNamedItem("marketType");
        String marketType = marketTypeNode.getNodeValue();

        String shipmentDate = "";
        NodeList packageList = null;
        NodeList packageChildList = null;
        NodeList articalChildList = null;

        Node consignmentNode = null;
        Node senderNode = null;
        Node receiverode = null;

        AascTNTZPLInfo aascTNTManifestInfo = new AascTNTZPLInfo();
        try {
            Node shipmentDateNode = root.selectSingleNode("/CONSIGNMENTBATCH/CONSIGNMENT/HEADER/SHIPMENTDATE/text()");
            shipmentDate = shipmentDateNode.getNodeValue();

            logger.info("Delivery Id : " + deliveryId + ",shipmentDate::::" + shipmentDate);
            aascTNTManifestInfo.setShipmentDate(shipmentDate);
        }catch (Exception e) {
            e.printStackTrace();
        }
        consignmentNode = root.selectSingleNode("/CONSIGNMENTBATCH/CONSIGNMENT");
        senderNode = root.selectSingleNode("/CONSIGNMENTBATCH/CONSIGNMENT/HEADER/SENDER");
        receiverode = root.selectSingleNode("/CONSIGNMENTBATCH/CONSIGNMENT/RECEIVER");

        aascTNTManifestInfo.setSenderCompanyName(nullStrToSpc(AascXmlParser.getValue((Element) senderNode, "COMPANYNAME")));
        aascTNTManifestInfo.setSenderStreet1(nullStrToSpc(AascXmlParser.getValue((Element) senderNode, "STREETADDRESS1")));
        aascTNTManifestInfo.setSenderStreet2(nullStrToSpc(AascXmlParser.getValue((Element) senderNode, "STREETADDRESS2")));
        aascTNTManifestInfo.setSenderStreet3(nullStrToSpc(AascXmlParser.getValue((Element) senderNode, "STREETADDRESS3")));
        aascTNTManifestInfo.setSenderCity(nullStrToSpc(AascXmlParser.getValue((Element) senderNode, "CITY")));
        aascTNTManifestInfo.setSenderProvince(nullStrToSpc(AascXmlParser.getValue((Element) senderNode, "PROVINCE")));
        aascTNTManifestInfo.setSenderPostCode(nullStrToSpc(AascXmlParser.getValue((Element) senderNode, "POSTCODE")));
        aascTNTManifestInfo.setSenderCountry(nullStrToSpc(AascXmlParser.getValue((Element) senderNode, "COUNTRY")));
        aascTNTManifestInfo.setSenderContactName(nullStrToSpc(AascXmlParser.getValue((Element) senderNode, "CONTACTNAME")));
        aascTNTManifestInfo.setSenderContactDialCode(nullStrToSpc(AascXmlParser.getValue((Element) senderNode, "CONTACTDIALCODE")));
        aascTNTManifestInfo.setSenderContactTelephone(nullStrToSpc(AascXmlParser.getValue((Element) senderNode, "CONTACTTELEPHONE")));
        aascTNTManifestInfo.setSenderContactEmail(nullStrToSpc(AascXmlParser.getValue((Element) senderNode, "CONTACTEMAIL")));
        aascTNTManifestInfo.setSenderAccount(nullStrToSpc(AascXmlParser.getValue((Element) senderNode, "ACCOUNT")));
        aascTNTManifestInfo.setReceiverCompanyName(nullStrToSpc(AascXmlParser.getValue((Element) receiverode, "COMPANYNAME")));
        aascTNTManifestInfo.setReceiverStreet1(nullStrToSpc(AascXmlParser.getValue((Element) receiverode, "STREETADDRESS1")));
        aascTNTManifestInfo.setReceiverStreet2(nullStrToSpc(AascXmlParser.getValue((Element) receiverode, "STREETADDRESS2")));
        aascTNTManifestInfo.setReceiverStreet3(nullStrToSpc(AascXmlParser.getValue((Element) receiverode, "STREETADDRESS3")));
        aascTNTManifestInfo.setReceiverCity(nullStrToSpc(AascXmlParser.getValue((Element) receiverode, "CITY")));
        aascTNTManifestInfo.setReceiverProvince(nullStrToSpc(AascXmlParser.getValue((Element) receiverode, "PROVINCE")));
        aascTNTManifestInfo
                .setReceiverPostCode(nullStrToSpc(AascXmlParser.getValue((Element) receiverode, "POSTCODE")));
        aascTNTManifestInfo
                .setReceiverCountry(nullStrToSpc(AascXmlParser.getValue((Element) receiverode, "COUNTRY")));
        aascTNTManifestInfo
                .setReceiverContactName(nullStrToSpc(AascXmlParser.getValue((Element) receiverode, "CONTACTNAME")));
        aascTNTManifestInfo.setReceiverContactDialCode(
                nullStrToSpc(AascXmlParser.getValue((Element) receiverode, "CONTACTDIALCODE")));
        aascTNTManifestInfo.setReceiverContactTelephone(
                nullStrToSpc(AascXmlParser.getValue((Element) receiverode, "CONTACTTELEPHONE")));
        aascTNTManifestInfo.setReceiverContactEmail(
                nullStrToSpc(AascXmlParser.getValue((Element) receiverode, "CONTACTEMAIL")));
        aascTNTManifestInfo
                .setReceiverAccount(nullStrToSpc(AascXmlParser.getValue((Element) receiverode, "ACCOUNT")));

        aascTNTManifestInfo
                .setConnumber(nullStrToSpc(AascXmlParser.getValue((Element) consignmentNode, "CONNUMBER")));
        aascTNTManifestInfo
                .setGoodsDesc1(nullStrToSpc(AascXmlParser.getValue((Element) consignmentNode, "GOODSDESC")));
        aascTNTManifestInfo
                .setDeliveryInst(nullStrToSpc(AascXmlParser.getValue((Element) consignmentNode, "DELIVERYINST")));
        aascTNTManifestInfo
                .setCustomerRef(nullStrToSpc(AascXmlParser.getValue((Element) consignmentNode, "CUSTOMERREF")));
        aascTNTManifestInfo.setService(nullStrToSpc(AascXmlParser.getValue((Element) consignmentNode, "SERVICE")));
        aascTNTManifestInfo.setInsuranceValue(
                nullStrToSpc(AascXmlParser.getValue((Element) consignmentNode, "INSURANCEVALUE")));
        aascTNTManifestInfo
                .setStatCode(nullStrToSpc(AascXmlParser.getValue((Element) consignmentNode, "STATCODE")));

        aascTNTManifestInfo.setTotalVolume(Double.parseDouble(AascXmlParser.getValue((Element) consignmentNode, "TOTALVOLUME")));
        //Added below code for #13663 by Vathsalya
        Node totalVolumeUnitsNode = root.selectSingleNode("/CONSIGNMENTBATCH/CONSIGNMENT/TOTALVOLUME").getAttributes().getNamedItem("units");
        logger.info("Delivery Id : " + deliveryId + ",totalVolumeUnitsNode value : "+totalVolumeUnitsNode.getNodeValue());
        aascTNTManifestInfo.setVolumeUOM(totalVolumeUnitsNode.getNodeValue());
        aascTNTManifestInfo.setTotalWeight(Double.parseDouble(AascXmlParser.getValue((Element) consignmentNode, "TOTALWEIGHT")));
        Node totalWeightUnitsNode = root.selectSingleNode("/CONSIGNMENTBATCH/CONSIGNMENT/TOTALWEIGHT").getAttributes().getNamedItem("units");
        logger.info("Delivery Id : " + deliveryId + ",totalVolumeUnitsNode value : "+totalWeightUnitsNode.getNodeValue());
        aascTNTManifestInfo.setWeightUOM(totalWeightUnitsNode.getNodeValue());
        aascTNTManifestInfo.setDangerousGoods(nullStrToSpc(AascXmlParser.getValue((Element) consignmentNode, "DANGEROUSGOODS")));
        aascTNTManifestInfo
                .setCurrency(nullStrToSpc(AascXmlParser.getValue((Element) consignmentNode, "CURRENCY")));
        aascTNTManifestInfo
                .setTotalItem(nullStrToSpc(AascXmlParser.getValue((Element) consignmentNode, "TOTALITEMS")));

        try {
            logger.info("Delivery Id : " + deliveryId + ",tnt goods value"+ nullStrToSpc(AascXmlParser.getValue((Element) consignmentNode, "GOODSVALUE")));
            if (AascXmlParser.getValue((Element) consignmentNode, "GOODSVALUE") != null
                    && AascXmlParser.getValue((Element) consignmentNode, "GOODSVALUE") != "")
                aascTNTManifestInfo.setGoodsValue(Double.parseDouble((nullStrToSpc(AascXmlParser.getValue((Element) consignmentNode, "GOODSVALUE")))));
        } catch (Exception e) {
            e.printStackTrace();
        }
        aascTNTManifestInfo
                .setPaymentType(nullStrToSpc(AascXmlParser.getValue((Element) consignmentNode, "PAYMENTIND")));

        AascTNTZPLInfo aascDimensionInfo = null;
        LinkedList dimensionList = new LinkedList();

        packageList = root.selectNodes("/CONSIGNMENTBATCH/CONSIGNMENT/PACKAGE");

        if (!"Connote".equalsIgnoreCase(connoteStr)) {
            if (packageList != null) {
                for (int i = 0; i < packageList.getLength(); i++) {
                    aascDimensionInfo = new AascTNTZPLInfo();
                    packageChildList = packageList.item(i).getChildNodes();
                    if (packageChildList != null) {
                        for (int j = 0; j < packageChildList.getLength(); j++) {
                            if("GOODSDESC".equals(packageChildList.item(j).getNodeName())){
                                aascDimensionInfo.setGoodsDesc1(nullStrToSpc(packageChildList.item(j).getChildNodes().item(0).getNodeValue()));
                            } else if ("LENGTH".equals(packageChildList.item(j).getNodeName())) {
                                aascDimensionInfo.setLength(Double.parseDouble(
                                        packageChildList.item(j).getChildNodes().item(0).getNodeValue()));
                                aascDimensionInfo.setUnitsUOM(nullStrToSpc(packageChildList.item(j).getAttributes()
                                        .getNamedItem("units").getNodeValue()));
                            } else if ("HEIGHT".equals(packageChildList.item(j).getNodeName())) {
                                aascDimensionInfo.setHeight(Double.parseDouble(
                                        packageChildList.item(j).getChildNodes().item(0).getNodeValue()));
                            } else if ("WIDTH".equals(packageChildList.item(j).getNodeName())) {
                                aascDimensionInfo.setWidth(Double.parseDouble(
                                        packageChildList.item(j).getChildNodes().item(0).getNodeValue()));
                            } else if ("WEIGHT".equals(packageChildList.item(j).getNodeName())) {
                                aascDimensionInfo.setWeight(Double.parseDouble(
                                        packageChildList.item(j).getChildNodes().item(0).getNodeValue()));
                                aascDimensionInfo.setWeightUOM(nullStrToSpc(packageChildList.item(j).getAttributes()
                                        .getNamedItem("units").getNodeValue()));
                            } else if ("VOLUME".equals(packageChildList.item(j).getNodeName())) {
                                aascDimensionInfo.setVolume(Double.parseDouble(
                                        packageChildList.item(j).getChildNodes().item(0).getNodeValue()));
                                aascDimensionInfo.setVolumeUOM(nullStrToSpc(packageChildList.item(j).getAttributes()
                                        .getNamedItem("units").getNodeValue()));
                            } else if ("ARTICLE".equals(packageChildList.item(j).getNodeName())) {
                                articalChildList = packageChildList.item(j).getChildNodes();
                                if(articalChildList != null) {
                                    for(int k = 0; k < articalChildList.getLength(); k++) {
                                        if("DESCRIPTION".equals(articalChildList.item(k).getNodeName())) {
                                            aascDimensionInfo.setGoodsDesc1(nullStrToSpc(articalChildList.item(k).getChildNodes().item(0).getNodeValue()));
                                        }
                                    }
                                }
                            }

                        }
                    }
                    try {
                        aascDimensionInfo.setPackageNumber(Integer
                                .parseInt(AascXmlParser.getValue((Element) packageList.item(i), "PACKAGEINDEX")));
                        aascDimensionInfo.setTotalItemNumber(
                                Integer.parseInt(AascXmlParser.getValue((Element) consignmentNode, "TOTALITEMS")));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    dimensionList.add(aascDimensionInfo);
                }
            }

        }
        aascTNTManifestInfo.setTrackingNumber(aascTNTManifestInfo.getConnumber());
        aascTNTManifestInfo.setDimenstionList(dimensionList);
        createManifest(marketType,
                       aascTNTManifestInfo,
                       aascDeliveryInfo,
                       aascProfileOptionsInfo,
                       connoteStr,
                       timeStampStr);

    } catch (Exception e) {
        e.printStackTrace();
    }
    logger.info("Exit from generateManifestConnote() Mathod");
}
