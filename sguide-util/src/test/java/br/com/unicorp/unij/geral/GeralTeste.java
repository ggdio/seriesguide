package br.com.unicorp.unij.geral;

import br.com.devteam.sguide.bean.render.Property;
import br.com.devteam.sguide.bean.render.Schema;
import br.com.devteam.sguide.bean.render.SchemaGenerator;

import com.thoughtworks.xstream.XStream;

public class GeralTeste {

	public static void main(String[] args) throws Exception {
		Schema schema = SchemaGenerator.getInstance().generate(ComplexBean.class);
		XStream xs = new XStream();
		xs.setMode(XStream.NO_REFERENCES);
		xs.alias("schema", Schema.class);
		xs.alias("property", Property.class);
		String xml = xs.toXML(schema);
		System.out.println(xml);
	}
	
}