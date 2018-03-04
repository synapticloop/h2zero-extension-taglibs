package synapticloop.h2zero.extension;

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
import java.util.Iterator;
import java.util.List;

import org.json.JSONObject;

import synapticloop.h2zero.extension.Extension;
import synapticloop.h2zero.model.Counter;
import synapticloop.h2zero.model.Database;
import synapticloop.h2zero.model.Finder;
import synapticloop.h2zero.model.Options;
import synapticloop.h2zero.model.Question;
import synapticloop.h2zero.model.Table;
import synapticloop.h2zero.model.View;
import synapticloop.h2zero.validator.BaseValidator;
import synapticloop.templar.Parser;
import synapticloop.templar.exception.ParseException;
import synapticloop.templar.exception.RenderException;
import synapticloop.templar.utils.TemplarContext;

/**
/**
 * This generator will generate all of the java classes for the tag libraries and the tag library descriptor file
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
		Iterator<Table> tableIterator = tables.iterator();

		while (tableIterator.hasNext()) {
			Table table = tableIterator.next();
			templarContext.add("table", table);
			logInfo("Generating for table '" + table.getName() + "'.");

			List<Finder> finders = table.getFinders();
			Iterator<Finder> finderIterator = finders.iterator();

			while (finderIterator.hasNext()) {
				Finder finder = finderIterator.next();
				templarContext.add("finder", finder);

				String pathname = outFile.getAbsolutePath() + options.getOutputCode() + database.getPackagePath() + "/taglib/" + table.getJavaFieldName() + "/" + finder.getTagName() + "Tag.java";
				renderToFile(templarContext, javaCreateTaglibFinderParser, pathname, verbose);
			}

			List<Counter> counters = table.getCounters();
			Iterator<Counter> counterIterator = counters.iterator();

			while(counterIterator.hasNext()) {
				Counter counter = counterIterator.next();
				templarContext.add("counter", counter);
				String pathname = outFile.getAbsolutePath() + options.getOutputCode() + database.getPackagePath() + "/taglib/" + table.getJavaFieldName() + "/" + counter.getTagName() + "Tag.java";
				renderToFile(templarContext, javaCreateTaglibCounterParser, pathname, verbose);
			}

			List<Question> questions = table.getQuestions();
			Iterator<Question> questionIterator = questions.iterator();

			while(questionIterator.hasNext()) {
				Question question = questionIterator.next();
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
		Iterator<View> viewsIterator = views.iterator();
		while (viewsIterator.hasNext()) {
			View view = viewsIterator.next();
			templarContext.add("view", view);
			// hack for finder taglibs for views - should be split out
			templarContext.add("table", view);

			List<Finder> finders = view.getFinders();
			Iterator<Finder> finderIterator = finders.iterator();

			while (finderIterator.hasNext()) {
				Finder finder = finderIterator.next();
				templarContext.add("finder", finder);

				String pathname = outFile.getAbsolutePath() + options.getOutputCode() + database.getPackagePath() + "/taglib/" + view.getJavaFieldName() + "/" + finder.getTagName() + "Tag.java";
				renderToFile(templarContext, javaCreateTaglibFinderParser, pathname, verbose);

				pathname = outFile.getAbsolutePath() + options.getOutputCode() + database.getPackagePath() + "/taglib/" + view.getJavaFieldName() + "/FindAllTag.java";
				renderToFile(templarContext, javaCreateTaglibFinderFindAllParser, pathname, verbose);

				pathname = outFile.getAbsolutePath() + options.getOutputCode() + database.getPackagePath() + "/taglib/" + view.getJavaFieldName() + "/CountAllTag.java";
				renderToFile(templarContext, javaCreateTaglibCounterCountAllParser, pathname, verbose);

			}
		}


		// the finder tld - for each database type
		String pathname = outFile.getAbsolutePath() + options.getOutputResources() + "/tld/" + database.getSchema() + "." + options.getDatabase() +".tld";
		renderToFile(templarContext, tldCreateLibraryParser, pathname, verbose);
	}

	@Override
	public List<BaseValidator> getValidators() {
		return null;
	}
}