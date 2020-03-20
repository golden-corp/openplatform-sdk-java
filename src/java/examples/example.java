package examples;

import com.golden.Sdk;
import com.golden.request.*;
import net.sf.json.JSON;
import net.sf.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class example {

    public static void main(String[] args) {
        try {
            Sdk sdk = new Sdk("EgDjckWzyGxwIi7e9J1A8LdruWMidFFH", "9Q8744Oe0nv8aw738b3HkjdylYZzNeZOcTz53KI4pchKpqIi", "test");
            JSONObject result = invoiceBlue(sdk);
            //JSONObject result = invoiceRed(sdk);
            System.out.println(result);
        } catch (IOException e) {
                e.printStackTrace();
        }catch (Exception e) {
                e.printStackTrace();
        }
    }

    public static JSONObject invoiceRed(Sdk sdk) throws IOException {
        JSONObject jsonObject = new JSONObject();
        ArrayList invoices = new ArrayList<JSONObject>();
        JSONObject invoice = new JSONObject();
        invoice.put("seller_taxpayer_num", "911101076819661132");//销方税号
        invoice.put("callback_url", "回掉地址");//销方税号
        invoice.put("order_sn", "6645588687037969410");//销方税号
        invoices.add(invoice);
        jsonObject.put("invoices", invoices);
        JSONObject result = sdk.httpPost("/invoice/red", jsonObject);
        return result;
    }

    public static JSONObject invoiceBlue(Sdk sdk) throws RuntimeException,IOException,IllegalAccessException, InvocationTargetException {
        InvoiceBlue blue = new InvoiceBlue();
        blue.setSellName("JACK测试企业12");
        blue.setSellerTaxpayerNum("911101076819661132");
        blue.setSellerAddress("");
        blue.setSellerTel("");
        blue.setSellerBankName("");
        blue.setSellerBankAccount("");
        blue.setTitleType(1);
        blue.setBuyerTitle("海南高灯科技");
        blue.setBuyerTaxpayerNum("");
        blue.setBuyerAddress("");
        blue.setBuyerBankAccount("");
        blue.setBuyerBankName("");
        blue.setBuyerPhone("");
        blue.setBuyerEmail("");
        blue.setTakerPhone("");
        blue.setOrderId("4651321213312");
        blue.setInvoiceTypeCode("032");
        blue.setCallbackUrl("https://www.baidu.com/xxs/callback");
        blue.setDrawer("lx");
        blue.setPayee("收到否");
        blue.setChecker("jack");
        blue.setUserOpenid("41345");
        blue.setSpecialInvoiceKind("");
        blue.setTerminalCode("");
        blue.setAmountHasTax(9508);
        blue.setTaxAmount(864);
        blue.setAmountWithoutTax(8644);
        blue.setRemark("sdd");

        InvoiceBlueGoodsInfo item = new InvoiceBlueGoodsInfo();
        item.setName("海鲜真划算");
        item.setTaxCode("1010499000000000000");
        item.setTaxType("");
        item.setModels("xyz");
        item.setUnit("个");
        item.setTotalPrice(8644);
        item.setTotal("5");
        item.setPrice("17.288");
        item.setTaxRate(100);
        item.setTaxAmount(864);
        item.setDiscount(0);
        item.setZeroTaxFlag("");
        item.setPreferentialPolicyFlag("");
        item.setVatSpecialManagement("");

        ArrayList<InvoiceBlueGoodsInfo> goodsInfos = new ArrayList<InvoiceBlueGoodsInfo>();
        goodsInfos.add(item);
       // goodsInfos.add(item);
        blue.setItems(goodsInfos);
        JSONObject result = sdk.invoiceBlue(blue);
        return result;
    }
}

