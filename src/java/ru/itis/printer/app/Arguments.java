package ru.itis.printer.app;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;

@Parameters(separators = "=")
public class Arguments {

	@Parameter(names = {"--black"})
	public String black;

	@Parameter(names = {"--white"})
	public String white;

	@Parameter(names = {"--path"})
	public String path;
}