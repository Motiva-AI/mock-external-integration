(ns mock-external-integration.lifecycle
  (:require [mock-external-integration.core :refer [uuid]]

            [schema.core :as schema]))

(defn create-campaign
  [campaign]
  (uuid))
