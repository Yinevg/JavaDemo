# 线程池
## 创建方式
1. 通过Executors工厂方法创建，底层通过ThreadPoolExecutor创建。
    1. newFixedThreadPool：定长线程池，可控制线程最大并发数，超出的线程会在队列中等待。
    2. newSingleThreadExecutor：创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行。
    3. newCachedThreadPool：创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程。
    4. newScheduledThreadPool：创建一个定长线程池，支持定时及周期性任务执行，使用ScheduledExecutorService来调用
2. 通过new ThreadPoolExecutor创建。
```
public ThreadPoolExecutor(
  int corePoolSize, // 线程池长期维持的线程数，即使线程处于Idle状态，也不会回收。
  int maximumPoolSize, // 线程数的上限
  long keepAliveTime, TimeUnit unit, // 超过corePoolSize的线程的idle时长，
                                     // 超过这个时间，多余的线程会被回收。
  BlockingQueue<Runnable> workQueue, // 任务的排队队列
  ThreadFactory threadFactory, // 新线程的产生方式
  RejectedExecutionHandler handler) // 拒绝策略
```
## 其他
1. 不需要返回值调用execute，需要返回值调用submit。
2. newCachedThreadPool和newScheduledThreadPool用可能导致OOM，这两种方式创建的最大线程数可能是Integer.MAX_VALUE。