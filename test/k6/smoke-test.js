import http from 'k6/http';
import { sleep } from 'k6';
import { BASEURL } from './config.js';

export const options = {
  vus: 1,
  duration: '10s',
};

export default function () {
  http.get(BASEURL);
  sleep(1);
}