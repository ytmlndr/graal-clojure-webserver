(ns app.pid
  (:import [java.lang.management ManagementFactory]))


(defn show []
  (let [[_ pid _hostname]
        (re-find #"^(\d+)@(.*)"
                 (.getName (ManagementFactory/getRuntimeMXBean)))]
    pid))
