//package com.auto.yung.graphql.simple.demo.provider;
//
//import com.google.common.base.Charsets;
//import com.google.common.io.Resources;
//import graphql.GraphQL;
//import graphql.schema.GraphQLSchema;
//import graphql.schema.StaticDataFetcher;
//import graphql.schema.idl.RuntimeWiring;
//import graphql.schema.idl.SchemaGenerator;
//import graphql.schema.idl.SchemaParser;
//import graphql.schema.idl.TypeDefinitionRegistry;
//import org.springframework.context.annotation.Bean;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.PostConstruct;
//import java.net.URL;
//
///**
// * @author yung
// * @date 2019-06-13 11:53
// */
//@Component
//public class GraphQLProvider {
//
//    private GraphQL graphQL;
//
//    private GraphQLSchema graphQLSchema;
//
//    @PostConstruct
//    public void init() throws Exception {
//        this.graphQLSchema = buildSchema();
//        this.graphQL = GraphQL.newGraphQL(this.graphQLSchema).build();
//    }
//
//    private GraphQLSchema buildSchema() throws Exception {
//        /**
//         * 方式一
//         */
//        /*String schema = "type Query {hello: String}";*/
//        /**
//         * 方式二
//         */
//        URL url = Resources.getResource("demohello.graphqls");
//        String schema = Resources.toString(url, Charsets.UTF_8);
//
//        SchemaParser schemaParser = new SchemaParser();
//        TypeDefinitionRegistry typeDefinitionRegistry = schemaParser.parse(schema);
//
//        RuntimeWiring runtimeWiring = buildWiring();
//
//        SchemaGenerator schemaGenerator = new SchemaGenerator();
//        return schemaGenerator.makeExecutableSchema(typeDefinitionRegistry, runtimeWiring);
//    }
//
//    private RuntimeWiring buildWiring() {
//        return RuntimeWiring.newRuntimeWiring()
//                .type("Query", builder -> builder.dataFetcher("hello", new StaticDataFetcher("LinWang")))
//                .build();
//    }
//
//    @Bean
//    public GraphQL graphQL() {
//        return graphQL;
//    }
//
//    @Bean
//    public GraphQLSchema graphQLSchema() {
//        return this.graphQLSchema;
//    }
//}
