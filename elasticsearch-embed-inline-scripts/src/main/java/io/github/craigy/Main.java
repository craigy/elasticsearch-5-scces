package io.github.craigy;

import org.eclipse.jetty.server.Server;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.client.Client;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.node.Node;
import org.elasticsearch.node.NodeBuilder;

public class Main {

	public static void main(String[] args) throws Exception {
		Server server = new Server(8080);

		server.start();

		Node node = NodeBuilder.nodeBuilder().data(true)
				.settings(Settings.builder().put("path.home", "target/es").build()).build();

		Client client = node.client();

		SearchRequest sr = new SearchRequest();

		System.out.println(client.search(sr));

		server.join();
	}
}
