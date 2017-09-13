(ns mock-external-integration.core
  (:import java.util.UUID))

(defn uuid []
  (UUID/randomUUID))
