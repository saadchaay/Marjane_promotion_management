<%--
  Created by IntelliJ IDEA.
  User: ssaad_chaay
  Date: 10/27/2022
  Time: 9:21 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Title</title>
        <script src="https://cdn.tailwindcss.com"></script>
        <script defer src="https://unpkg.com/alpinejs@3.x.x/dist/cdn.min.js"></script>
    </head>
    <body>
        <section class="bg-white">
          <div class="lg:grid lg:min-h-screen lg:grid-cols-12">
            <section
                    class="relative flex h-32 items-end bg-gray-900 lg:col-span-5 lg:h-full xl:col-span-6"
            >
              <img
                      alt="Night"
                      src="https://www.dragonrouge.com/wp-content/uploads/2018/02/1707_DR_Maroc_Marjane_Siraudeau-160-1440x0-c-default.jpg"
                      class="absolute inset-0 h-full w-full object-cover opacity-80"
              />

              <div class="hidden lg:relative lg:block lg:p-12">
                <a class="block text-white" href="/">
                  <span class="sr-only">Home</span>

                </a>

                <h2 class="mt-6 text-2xl font-bold text-white sm:text-3xl md:text-4xl">
                  Welcome to Marjane Market Service Promotion
                </h2>

                <p class="mt-4 leading-relaxed text-white/90">
                  Lorem, ipsum dolor sit amet consectetur adipisicing elit. Eligendi nam
                  dolorum aliquam, quibusdam aperiam voluptatum.
                </p>
              </div>
            </section>

            <main
                    aria-label="Main"
                    class="flex items-center justify-center px-8 py-8 sm:px-12 lg:col-span-7 lg:py-12 lg:px-16 xl:col-span-6"
            >
              <div class="max-w-xl lg:max-w-3xl">
                <div class="relative -mt-16 block lg:hidden">
                  <a
                          class="inline-flex h-16 w-16 items-center justify-center rounded-full bg-white text-blue-600 sm:h-20 sm:w-20"
                          href="${pageContext.request.contextPath}/"
                  >
                    <span class="sr-only">Home</span>

                  </a>

                  <h1 class="mt-2 text-2xl font-bold text-gray-900 sm:text-3xl md:text-4xl">
                    Welcome to Marjane Market Service Promotion
                  </h1>

                  <p class="mt-4 leading-relaxed text-gray-500">
                    Lorem, ipsum dolor sit amet consectetur adipisicing elit. Eligendi
                    nam dolorum aliquam, quibusdam aperiam voluptatum.
                  </p>
                </div>

                <div class="flex-1 flex flex-col justify-center py-12 px-4 sm:px-6 lg:flex-none lg:px-20 xl:px-24">
                  <div class="mx-auto w-full max-w-sm lg:w-96">
                    <div>
                      <img class="h-20 w-22" src=https://17w3553h9rihf1psv1awdh71-wpengine.netdna-ssl.com/wp-content/uploads/2013/02/marjane2-300x203.png" alt="Workflow">
                      <h2 class="mt-3 text-3xl font-extrabold text-gray-900">Welcome, Login to your account</h2>
                    </div>

                    <div class="mt-6">
                      <div class="mt-4">
                        <form action="#" method="POST" class="space-y-6" x-data="{ open: false }">

                          <div x-show="open">
                            <label for="username" class="block text-sm font-medium text-gray-700"> Username </label>
                            <div class="mt-1">
                              <input id="username" name="username" type="text" autocomplete="username" required class="appearance-none block w-full px-3 py-2 border border-gray-300 shadow-sm placeholder-gray-400 focus:outline-none focus:ring-indigo-500 focus:border-indigo-500 sm:text-sm">
                            </div>
                          </div>

                          <div x-show="!open" >
                            <label for="email" class="block text-sm font-medium text-gray-700"> Email address </label>
                            <div class="mt-1">
                              <input id="email" name="email" type="email" autocomplete="email" required class="appearance-none block w-full px-3 py-2 border border-gray-300 shadow-sm placeholder-gray-400 focus:outline-none focus:ring-indigo-500 focus:border-indigo-500 sm:text-sm">
                            </div>
                          </div>

                          <div >
                            <label for="password" class="block text-sm font-medium text-gray-700"> Password </label>
                            <div class="mt-1">
                              <input id="password" name="password" type="password" autocomplete="current-password" required class="appearance-none block w-full px-3 py-2 border border-gray-300 shadow-sm placeholder-gray-400 focus:outline-none focus:ring-indigo-500 focus:border-indigo-500 sm:text-sm">
                            </div>
                          </div>

                          <div class="mt-6 relative">
                            <div class="absolute inset-0 flex items-center" aria-hidden="true">
                              <div class="w-full border-t border-gray-300"></div>
                            </div>
                            <div class="relative flex justify-center text-sm">
                              <span class="px-2 bg-white text-gray-500"> Choose your position </span>
                            </div>
                          </div>

                          <div class="flex items-center justify-between">
                            <div>
                              <label>
                                <span class="text-sm">General admin </span>
                                <input x-on:click="open = true" name="role" value="general-admin" type="radio" class="h-3 w-3 text-indigo-600 focus:ring-indigo-500 border-gray-300 rounded">
                              </label>
                            </div>
                            <div>
                              <label>
                                <span class="text-sm">Admin </span>
                                <input x-on:click="open = false" name="role" value="admin" type="radio" class="h-3 w-3 text-indigo-600 focus:ring-indigo-500 border-gray-300 rounded">
                              </label>
                            </div>
                            <div>
                              <label>
                                <span class="text-sm">Manager </span>
                                <input x-on:click="open = false" name="role" value="manager" type="radio" class="h-3 w-3 text-indigo-600 focus:ring-indigo-500 border-gray-300 rounded">
                              </label>
                            </div>
                          </div>

                          <div>
                            <button type="submit" class="w-full flex justify-center py-2 px-4 border border-transparent shadow-sm text-sm font-medium text-white bg-blue-800 hover:bg-blue-900 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-blue-800">Login</button>
                          </div>
                        </form>
                      </div>
                    </div>
                  </div>
                </div>

              </div>
            </main>
          </div>
        </section>
    </body>
</html>
