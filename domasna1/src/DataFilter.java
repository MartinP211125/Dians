import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DataFilter {
    public static List<String> removeUselessData(List<String> tags, int id){
        return getData(tags, id);
    }
    private static List<String> getData(List<String> tags, int id){
        List<String> data = new ArrayList<>(); // name , address, phone, website, opening_hours
        String name = "Not specified", address = "Not specified", phone = "Not specified", website = "Not specified", openingHr = "Not specified", name1 = "Not specified";
        data.add(String.valueOf(id));
        for (String i : tags){
            if (i.startsWith("  <tag k=\"name\" v=\"")) {
                name = i;
                name = name.replaceAll("  <tag k=\"name\" v=\"", "");
                name = name.replaceAll("\"/>", "");
                if(name.equals("Сковин") && id == 4){
                   data.add(name);
                }else if(name.equals("Vinarija Stobi") && id == 2){
                    data.add(name);
                }else if(name.equals("Domaine Lepovo") && id == 7){
                    data.add(name);
                }
            }else if(i.startsWith("  <tag k=\"name:en\"")){
                if(id != 4){
                    name1 = i;
                    name1 = name1.replaceAll("  <tag k=\"name:en\" v=\"", "");
                    name1 = name1.replaceAll("\"/>", "");
                    if(name1.equals("Municipal roads (Gradsko)")){
                        name1 = "Not specified";
                    }else if(name.equals("Chateau Sopot") && id == 6){
                        data.add(name1);
                    }
                }

            }else if (i.startsWith("  <tag k=\"addr:city\"")){
                address = i;
                address = address.replaceAll("  <tag k=\"addr:city\" v=\"", "");
                address = address.replaceAll("\"/>", "");
            } else if (i.startsWith("  <tag k=\"to\" v=") && address.equals("Not specified")) {
                address = i;
                address = address.replaceAll("  <tag k=\"to\" v=\"", "");
                address = address.replaceAll("\"/>", "");
            } if(i.startsWith("  <tag k=\"phone\"")){
                phone = i;
                phone = phone.replaceAll("  <tag k=\"phone\" v=\"", "");
                phone = phone.replaceAll("\"/>", "");
            }else if(i.startsWith("  <tag k=\"website\"")){
                website = i;
                website = website.replaceAll("  <tag k=\"website\" v=\"", "");
                website = website.replaceAll("\"/>", "");
            }else if(i.startsWith("  <tag k=\"opening_hours\"")){
                openingHr = i;
                openingHr = openingHr.replaceAll("  <tag k=\"opening_hours\" v=\"", "");
                openingHr = openingHr.replaceAll("\"/>", "");
            }
        }

        if(!name.equals("Not specified")){
            data.add(name);

        }else if(!name1.equals("Not specified")){
            data.add(name1);
        }
        data.add(address);
        data.add(phone);
        data.add(website);
        data.add(openingHr);
        return data;
    }
}
