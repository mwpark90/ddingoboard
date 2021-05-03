<template>
    <v-app id="inspire">
      <v-app id="inspire">
        <v-main>
          <v-container
            class="fill-height"
            fluid
          >
            <v-row
              align="center"
              justify="center"
            >
              <v-col
                cols="12"
                sm="8"
                md="4"
              >
                <v-card class="elevation-12">
                  <v-toolbar
                    color="primary"
                    dark
                    flat
                  >
                    <v-toolbar-title>Login form</v-toolbar-title>
                    <v-spacer></v-spacer>
                  </v-toolbar>
                  <v-card-text>
                    <v-form>
                      <v-text-field
                        v-model="logindata.username"
                        label="Login"
                        name="login"
                        prepend-icon="mdi-account"
                        type="text"
                      ></v-text-field>

                      <v-text-field
                        v-model="logindata.password"
                        id="password"
                        label="Password"
                        name="password"
                        prepend-icon="mdi-lock"
                        type="password"
                      ></v-text-field>
                    </v-form>
                  </v-card-text>
                  <v-card-actions>
                    <v-spacer></v-spacer>
                    <v-btn color="primary" v-on:click="fetchContacts(logindata)">Login</v-btn>
                  </v-card-actions>
                </v-card>
              </v-col>
            </v-row>
          </v-container>
        </v-main>
      </v-app>
    </v-app>
</template>

<script>
import axios from "axios";

export default {
  name: "login",
  data() {
    return {
      logindata: {
        username: ''
        , password: ''
      }
    }
  },
  methods : {
    fetchContacts : function(logindata) {
      const CancelToken = axios.CancelToken;
      const source = CancelToken.source();

      axios({
        method: 'GET',
        url : '/user/login',
        data:{
          "email": logindata.username,
          "password": logindata.password
        },
        headers: {'X-CSRFToken': '${_csrf.token}'},
      }).then((response) => {
          console.log(response)
      }).catch((ex)=> {
          console.log(ex.message)
      })
    },
  }
};
</script>

<style scoped>

</style>
