package lt.keizik.ieva.article;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/article")
public class ArticleController {

	private ArticleService articleService;

	public ArticleController(ArticleService articleService) {
		this.articleService = articleService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<Article> getArticles() {
		return articleService.getArticles();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/search/{title}")
	public List<Article> searchArticles(@PathVariable String title) {
		return articleService.getArticles().stream()
				.filter(a -> a.getTitle().toLowerCase().contains(title.toLowerCase())).collect(Collectors.toList());
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public Article getArticle(@PathVariable Long id) {
		return articleService.getArticle(id);
	}

	@RequestMapping(method = RequestMethod.POST)
	public Article create(@RequestBody Article article) {
		return articleService.save(article);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/{id}")
	public void update(@RequestBody Article article, @PathVariable Long id) {
		articleService.save(article);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public void delete(@PathVariable Long id) {
		articleService.delete(id);
	}

}
