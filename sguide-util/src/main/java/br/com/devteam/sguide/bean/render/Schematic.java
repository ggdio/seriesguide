package br.com.devteam.sguide.bean.render;

/**
 * Interface for typing only
 * <p>It informs the {@link SchemaGenerator} that the classe contains a method called toSchema()
 * <p>I order to use it, the programmer MUST create a static method with a signature like below:
 * <p><b>public static Schema toSchema(){}</b>
 * @author Guilherme Dio
 *
 */
public interface Schematic {
	public static final String METHOD = "toSchema";
}
