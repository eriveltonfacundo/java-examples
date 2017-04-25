package br.com.example.scheduler.guava;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import com.google.common.util.concurrent.AbstractScheduledService;

public class ScheduledExecutor extends AbstractScheduledService {
	
	private final Logger logger = Logger.getLogger(getClass());
	
	@Override
	protected void runOneIteration() throws Exception {
		logger.info("Executing....");
	}

	@Override
	protected void startUp() {
		logger.info("StartUp Activity....");
	}

	@Override
	protected void shutDown() {
		logger.info("Shutdown Activity...");
	}

	@Override
	protected Scheduler scheduler() {
		return Scheduler.newFixedRateSchedule(0, 1, TimeUnit.SECONDS);
	}

	public static void main(String[] args) throws InterruptedException {
		BasicConfigurator.configure();
		
		ScheduledExecutor scheduledExecutor = new ScheduledExecutor();
		scheduledExecutor.startAsync();
		Thread.sleep(15000);
		scheduledExecutor.stopAsync();
	}
}