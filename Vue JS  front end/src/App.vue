<template>
  <div class="container">
    <div class="col-6">
      <img src="../src/assets/logo.png" style="width: 100%" />
    </div>
    <div class="col-6">
      <h1>Enter your name</h1>
      <input type="text" class="form form-control" v-model="this.name" placeholder="Enter your name here...!">
      <br />
      <button @click="fetchGreeting('en')" class="btn btn-primary" style="margin-top: 10px;">Convert to English</button>&nbsp;
      <button @click="fetchGreeting('fr')" class="btn btn-primary" style="margin-top: 10px;">Convert to French</button>&nbsp;
      <button @click="fetchGreeting('zh')" class="btn btn-primary" style="margin-top: 10px;">Convert to China</button>&nbsp;
      <button @click="fetchGreeting('ru')" class="btn btn-primary" style="margin-top: 10px;">Convert to Russian</button>&nbsp;
      <button @click="fetchGreeting('ta')" class="btn btn-primary" style="margin-top: 10px;">Convert to Tamil</button>&nbsp;
      <button @click="fetchGreeting('si')" class="btn btn-primary" style="margin-top: 10px;">Convert to Sinhala</button>&nbsp;
    </div>
    <br />
  </div>

  <div class="row" v-if="this.greeting != ''">
    <hr />
    <div class="col-12">
      <p>Result is </p>
      <div class="alert alert-success">{{ greeting }}</div>
    </div>
  </div>
</template>


<style>
.container {
    height: 100%;
    display: flex;
    justify-content: center;
    align-items: center;
}
</style>

<script>
import axiosInstance from '../src/services/axiosInstance';

export default {
  data() {
    return {
      name: "",
      greeting: ""
    };
  },
  methods: {
    fetchGreeting(lang) {
      axiosInstance.get('http://192.168.200.250:8080/greeting', {
        params: {
          name: this.name,
          lang: lang
        }
      })
        .then(response => {
          this.greeting = response.data;
        })
        .catch(error => {
          console.error('Error fetching greeting:', error);
        });
    }
  }
};
</script>