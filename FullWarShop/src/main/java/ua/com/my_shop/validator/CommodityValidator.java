package ua.com.my_shop.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ua.com.my_shop.dao.CommodityDao;
import ua.com.my_shop.entity.Commodity;

@Component("commodityValidator")
public class CommodityValidator implements Validator{

	@Autowired
	private CommodityDao commodityDao;
	
	public void validate(Object object) throws Exception {
		
		Commodity commodity = (Commodity)object;
		
		if(commodity.getName().isEmpty()){
			throw new CommodityValidationException(CommodityValidationMessages.EMPTY_NAME_FIELD);
		}
		if(commodityDao.findByName(commodity.getName()) != null){
			throw new CommodityValidationException(CommodityValidationMessages.COMMODITY_NAME_ALLREADY_EXCISTS);
		}
		
		
	}

	
	
}
