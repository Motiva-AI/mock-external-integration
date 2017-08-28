(ns mock-external-integration.handler-test
  (:require [clojure.test :refer :all]
            [bond.james :as bond]

            [mock-external-integration.handler :as h]
            [mock-external-integration.gateway :as gw]

            [ring.util.http-status :refer :all]))

(deftest handle-get-email-test
  (testing "gateway 404 not found"
    (bond/with-stub! [[gw/emails (constantly nil)]
                      [gw/email  (constantly nil)]]
      ))

  (testing "gateway null"
    (bond/with-stub! [[gw/emails (constantly nil)]
                      [gw/email  (constantly nil)]]
      ))

  (testing "gateway malformed data structure"
    (bond/with-stub! [[gw/emails (constantly nil)]
                      [gw/email  (constantly nil)]]
      ))

  (testing "gateway empty body"
    (bond/with-stub! [[gw/emails (constantly {})]
                      [gw/email  (constantly {})]]
      ))

  (testing "Happy case"
    (bond/with-stub! [[gw/emails (constantly nil)]
                      [gw/email  (constantly nil)]]
      )))
