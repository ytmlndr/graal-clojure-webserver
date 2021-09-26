(defproject app "0.1.0-SNAPSHOT"
  :dependencies [[org.clojure/clojure "1.9.0"]
                 [http-kit "2.3.0"]
                 [ring/ring-core "1.6.3"]
                 [ring/ring-json "0.4.0"]
                 [compojure "1.6.1"]
                 [clj-http-lite "0.3.0"]]
  :plugins [[io.taylorwood/lein-native-image "0.3.1"]]
  :target-path "target/%s"
  :native-image {:jvm-opts  ["-Dclojure.compiler.direct-linking=true"]
                 :opts      ["-H:EnableURLProtocols=http"
                             "--report-unsupported-elements-at-runtime"
                             "--initialize-at-build-time"
                             "--no-server"
                             "--no-fallback"
                             "--verbose"]
                 :name      "server"}
  :main app.core
  :profiles {:uberjar {:aot :all}}
  :repl-options {:init-ns app.core})
