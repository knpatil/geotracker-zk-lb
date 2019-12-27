package com.kpatil.microservices.geotracker.lb;

import java.net.URI;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.RetryNTimes;
import org.apache.curator.x.discovery.ServiceDiscovery;
import org.apache.curator.x.discovery.ServiceDiscoveryBuilder;
import org.apache.curator.x.discovery.ServiceProvider;

public class ZookeeperServiceDiscovery {

  private static ServiceProvider<Object> geotrackerServiceProvider;

  private static ServiceProvider<Object> getGeotrackerServiceProvider() throws Exception {
    if (geotrackerServiceProvider == null) {
      CuratorFramework curatorFramework = CuratorFrameworkFactory
          .newClient("zookeeper:2181", new RetryNTimes(5, 1000));
      curatorFramework.start();

      ServiceDiscovery<Object> serviceDiscovery = ServiceDiscoveryBuilder.builder(Object.class)
          .basePath("com.kpatil.microservices.geotracker")
          .client(curatorFramework)
          .build();
      serviceDiscovery.start();

      geotrackerServiceProvider = serviceDiscovery.serviceProviderBuilder()
          .serviceName("geotracker").build();
      geotrackerServiceProvider.start();
    }
    return geotrackerServiceProvider;
  }

  public static URI getGeotrackerServiceUri() throws Exception {
    return new URI(getGeotrackerServiceProvider().getInstance().buildUriSpec());
  }
}
