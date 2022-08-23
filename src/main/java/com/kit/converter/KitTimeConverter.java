package com.kit.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.kit.util.KitTime;

/**
 * @author Zubayer Ahamed
 * @since Aug 23, 2022
 */
@Converter
public class KitTimeConverter implements AttributeConverter<KitTime, String> {

	@Override
	public String convertToDatabaseColumn(KitTime time) {
		return time == null ? null : time.getT5Time();
	}

	@Override
	public KitTime convertToEntityAttribute(String data) {
		return data == null || data.isEmpty() ? null : new KitTime(data);
	}

}
