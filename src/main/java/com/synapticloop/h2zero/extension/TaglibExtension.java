package com.synapticloop.h2zero.extension;

/*
 * Copyright (c) 2018 synapticloop.
 * 
 * All rights reserved.
 *
 * This source code and any derived binaries are covered by the terms and
 * conditions of the Licence agreement ("the Licence").  You may not use this
 * source code or any derived binaries except in compliance with the Licence.
 * A copy of the Licence is available in the file named LICENCE shipped with
 * this source code or binaries.
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the Licence is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * Licence for the specific language governing permissions and limitations
 * under the Licence.
 */

import java.io.File;
import java.util.*;

import com.synapticloop.h2zero.generator.model.Database;
import com.synapticloop.h2zero.generator.model.Options;
import org.apache.commons.collections.IteratorUtils;
import org.json.JSONObject;

import com.synapticloop.h2zero.generator.extension.Extension;
import com.synapticloop.h2zero.generator.model.Counter;
import com.synapticloop.h2zero.generator.model.Database;
import com.synapticloop.h2zero.generator.model.Finder;
import com.synapticloop.h2zero.generator.model.Options;
import com.synapticloop.h2zero.generator.model.Question;
import com.synapticloop.h2zero.generator.model.Table;
import com.synapticloop.h2zero.generator.model.View;
import com.synapticloop.h2zero.generator.validator.BaseValidator;
import com.synapticloop.templar.Parser;
import com.synapticloop.templar.exception.ParseException;
import com.synapticloop.templar.exception.RenderException;
import com.synapticloop.templar.utils.TemplarContext;

/**
/**
 * This generator will generate all java classes for the tag libraries and the tag
 * library descriptor file
 * 
 * <ul>
 *   <li>Finders</li>
 *   <li>Counters</li>
 *   <li>Questions</li>
 *   <li>FindByPrimaryKey</li>
 *   <li>FindAll</li>
 *   <li>CountAll</li>
 * </ul>
 * 
 * @author synapticloop
 */

public class TaglibExtension extends Extension {
	/** <p>The output directory </p> */
	public static final String KEY_WEBAPP_OUTPUT_DIR = "webappOutputDir";

	private static final Map<String, String> REQUIRED_OPTIONS = new HashMap<>();
	static {
		REQUIRED_OPTIONS.put(KEY_WEBAPP_OUTPUT_DIR, "Output directory for webapps - think 'src/main/webapp'");
	}

	@Override public String getRequiredOutputOptionDescription(String optionName) {
		return(REQUIRED_OPTIONS.getOrDefault(KEY_WEBAPP_OUTPUT_DIR, "No description given."));
	}

	@Override public List<String> getRequiredOutputOptions() {
		return(IteratorUtils.toList(REQUIRED_OPTIONS.keySet().iterator()));
	}

	@Override public Map<String, String> getDefaultOutputOptions() {
		// TODO - static please
		Map<String, String> defaultOptions = new HashMap<>();
		defaultOptions.put("webappWebInfDir", "src/main/webapp");
		return(defaultOptions);
	}

	@Override
	public void generate(JSONObject extensionOptions, Database database, Options options, File outFile, boolean verbose) throws RenderException, ParseException {
		// you __ALWAYS__ want to get the defaultTemplarContext.
		TemplarContext templarContext = getDefaultTemplarContext(extensionOptions, database, options);

		Parser javaCreateTaglibFinderParser = getParser("/java-create-taglib-finder.templar", verbose);
		Parser javaCreateTaglibCounterParser = getParser("/java-create-taglib-counter.templar", verbose);
		Parser javaCreateTaglibQuestionParser = getParser("/java-create-taglib-question.templar", verbose);
		Parser javaCreateTaglibFinderFindByPrimaryKeyParser = getParser("/java-create-taglib-finder-find-by-primary-key.templar", verbose);
		Parser javaCreateTaglibFinderFindAllParser = getParser("/java-create-taglib-finder-find-all.templar", verbose);
		Parser javaCreateTaglibCounterCountAllParser = getParser("/java-create-taglib-counter-count-all.templar", verbose);

		// the TLD
		Parser tldCreateLibraryParser = getParser("/tld-create-library.templar", verbose);

		// now for the tables
		List<Table> tables = database.getTables();

		for (Table table : tables) {
			templarContext.add("table", table);
			logInfo("Generating for table '" + table.getName() + "'.");

			List<Finder> finders = table.getFinders();

			for (Finder finder : finders) {
				templarContext.add("finder", finder);

				String pathname = outFile.getAbsolutePath() + options.getOutputCode() + database.getPackagePath() + "/taglib/" + table.getJavaFieldName() + "/" + finder.getTagName() + "Tag.java";
				renderToFile(templarContext, javaCreateTaglibFinderParser, pathname, verbose);
			}

			List<Counter> counters = table.getCounters();

			for (Counter counter : counters) {
				templarContext.add("counter", counter);
				String pathname = outFile.getAbsolutePath() + options.getOutputCode() + database.getPackagePath() + "/taglib/" + table.getJavaFieldName() + "/" + counter.getTagName() + "Tag.java";
				renderToFile(templarContext, javaCreateTaglibCounterParser, pathname, verbose);
			}

			List<Question> questions = table.getQuestions();

			for (Question question : questions) {
				templarContext.add("question", question);
				String pathname = outFile.getAbsolutePath() + options.getOutputCode() + database.getPackagePath() + "/taglib/" + table.getJavaFieldName() + "/" + question.getTagName() + "Tag.java";
				renderToFile(templarContext, javaCreateTaglibQuestionParser, pathname, verbose);
			}


			// the extra 'missing' finders
			String pathname = outFile.getAbsolutePath() + options.getOutputCode() + database.getPackagePath() + "/taglib/" + table.getJavaFieldName() + "/" + "FindByPrimaryKeyTag.java";
			renderToFile(templarContext, javaCreateTaglibFinderFindByPrimaryKeyParser, pathname, verbose);

			pathname = outFile.getAbsolutePath() + options.getOutputCode() + database.getPackagePath() + "/taglib/" + table.getJavaFieldName() + "/FindAllTag.java";
			renderToFile(templarContext, javaCreateTaglibFinderFindAllParser, pathname, verbose);

			pathname = outFile.getAbsolutePath() + options.getOutputCode() + database.getPackagePath() + "/taglib/" + table.getJavaFieldName() + "/CountAllTag.java";
			renderToFile(templarContext, javaCreateTaglibCounterCountAllParser, pathname, verbose);
		}

		// now for the views
		List<View> views = database.getViews();
		for (View view : views) {
			templarContext.add("view", view);
			// hack for finder taglibs for views - should be split out
			templarContext.add("table", view);

			List<Finder> finders = view.getFinders();

			for (Finder finder : finders) {
				templarContext.add("finder", finder);

				String pathname = outFile.getAbsolutePath() + options.getOutputCode() + database.getPackagePath() + "/taglib/" + view.getJavaFieldName() + "/" + finder.getTagName() + "Tag.java";
				renderToFile(templarContext, javaCreateTaglibFinderParser, pathname, verbose);

				pathname = outFile.getAbsolutePath() + options.getOutputCode() + database.getPackagePath() + "/taglib/" + view.getJavaFieldName() + "/FindAllTag.java";
				renderToFile(templarContext, javaCreateTaglibFinderFindAllParser, pathname, verbose);

				pathname = outFile.getAbsolutePath() + options.getOutputCode() + database.getPackagePath() + "/taglib/" + view.getJavaFieldName() + "/CountAllTag.java";
				renderToFile(templarContext, javaCreateTaglibCounterCountAllParser, pathname, verbose);

			}
		}


		// the tlds - for each database type
		String pathname = outFile.getAbsolutePath() + "/" + extensionOptions.getString(KEY_WEBAPP_OUTPUT_DIR)  + "/WEB-INF/tld/" + database.getSchema() + "." + options.getDatabase() +".tld";
		renderToFile(templarContext, tldCreateLibraryParser, pathname, verbose);
	}

	@Override
	public List<BaseValidator> getValidators() {
		return null;
	}
}